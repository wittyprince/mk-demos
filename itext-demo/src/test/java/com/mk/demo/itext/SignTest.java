package com.mk.demo.itext;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDate;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.CertificateUtil;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.ITSAClient;
import com.itextpdf.signatures.PdfPKCS7;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;
import com.itextpdf.signatures.SignaturePermissions;
import com.itextpdf.signatures.SignatureUtil;
import com.itextpdf.signatures.TSAClientBouncyCastle;
import org.bouncycastle.jcajce.provider.asymmetric.x509.CertificateFactory;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;

/**
 * sign test
 *
 * @author WangChen
 * Created on 2019/2/22 23:37
 * @since 1.0
 */
public class SignTest {

    private String keyStorePath = "D:\\wangchen\\tools/ks";
    private String keyStorePwd = "password";
    private final static String RFC3161_STANDARD = "http://rfc3161timestamp.globalsign.com/standard";

    @Test
    public void test1(){
        String src = "D:\\tmp/hello3.pdf";
        String dest = "D:\\tmp/signatures/hello_signed0.pdf";
        String reason = "测试签名reason";
        String location = "Asia/Shanghai";
        Rectangle rect = new Rectangle(36, 648, 200, 100);
        int pageNum = 1;
        signature(src, dest, reason, location, rect, pageNum);
    }

    public void signature(String src, String dest, String reason, String location, Rectangle rect, int pageNum) {
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);

        KeyStore ks = null;
        String alias = null;
        PrivateKey pk = null;
        Certificate[] chain = null;
        try {
            ks = getKeyStore(null, keyStorePath, keyStorePwd);
            alias = ks.aliases().nextElement();
            pk = (PrivateKey) ks.getKey(alias, keyStorePwd.toCharArray());
            chain = ks.getCertificateChain(alias);
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException | UnrecoverableKeyException e) {
            e.printStackTrace();
        }

        ITSAClient tsaClient = null;
        Certificate cert = chain[0];
        if (cert instanceof X509Certificate){
            tsaClient = getTSAClient((X509Certificate) cert);
        }
        if (tsaClient == null){
        }
            tsaClient = new TSAClientBouncyCastle(RFC3161_STANDARD);

        // Creating the reader and the signer
        PdfReader reader = null;
        PdfSigner signer = null;
        PdfFont font = null;
        StampingProperties stampingProperties = new StampingProperties();
        try {
            reader = new PdfReader(src);
            signer = new PdfSigner(reader, new FileOutputStream(dest), stampingProperties);
            font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Creating the appearance
        PdfSignatureAppearance appearance = signer.getSignatureAppearance()
                .setLayer2Font(font)
                .setReason(reason)
                .setLocation(location)
                .setReuseAppearance(false);
        // Rectangle rect = new Rectangle(36, 648, 200, 100);
        appearance
                .setPageRect(rect)
                .setPageNumber(pageNum);
        // signer.setFieldName("sig");
        // Creating the signature
        IExternalSignature pks = new PrivateKeySignature(pk, DigestAlgorithms.SHA512, provider.getName());
        IExternalDigest digest = new BouncyCastleDigest();
        try {
            signer.signDetached(digest, pks, chain, null, null, tsaClient, 0, PdfSigner.CryptoStandard.CADES);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }

    KeyStore getKeyStore(String keyStoreType, String keyStorePath, String keyStorePwd)
            throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException {
        if (Objects.isNull(keyStoreType)){
            keyStoreType = KeyStore.getDefaultType();
        }
        KeyStore keyStore = KeyStore.getInstance(keyStoreType);
        keyStore.load(new FileInputStream(keyStorePath), keyStorePwd.toCharArray());
        return keyStore;
    }

    ITSAClient getTSAClient(X509Certificate certificate){
        String tsaUrl = CertificateUtil.getTSAURL(certificate);
        if (tsaUrl == null){
            return null;
        }
        return new TSAClientBouncyCastle(tsaUrl);
    }

    @Test
    public void tesInspectSignatures() throws IOException, GeneralSecurityException {
        String path = "D:/tmp/hello2.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(path));
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, false);
        SignaturePermissions perms = null;
        SignatureUtil signUtil = new SignatureUtil(pdfDoc);
        List<String> names = signUtil.getSignatureNames();
        for (String name : names) {
            System.out.println("===== " + name + " =====");
            perms = inspectSignature(pdfDoc, signUtil, form, name, perms);
        }
        System.out.println();
    }

    private SignaturePermissions inspectSignature(PdfDocument pdfDoc, SignatureUtil signUtil, PdfAcroForm form, String name, SignaturePermissions perms) throws GeneralSecurityException, IOException {
        if (form.getField(name).getWidgets() != null && form.getField(name).getWidgets().size() > 0) {
            int pageNum = 0;
            Rectangle pos = form.getField(name).getWidgets().get(0).getRectangle().toRectangle();
            for (int i = 1; i <= pdfDoc.getNumberOfPages(); i++) {
                PdfPage page = pdfDoc.getPage(i);
                for (PdfAnnotation annot : page.getAnnotations()) {
                    System.out.println();
                    if (PdfName.Sig.equals(annot.getPdfObject().get(PdfName.FT)) && name.equals(annot.getPdfObject().get(PdfName.T).toString())) {
                        pageNum = pdfDoc.getPageNumber(page);
                        break;
                    }
                }
            }
            if (pos.getWidth() == 0 || pos.getHeight() == 0) {
                System.out.println("Invisible signature");
            } else {
                System.out.println(String.format("Field on page %s; llx: %s, lly: %s, urx: %s; ury: %s", pageNum, pos.getLeft(), pos.getBottom(), pos.getRight(), pos.getTop()));
            }
        }

        /*PdfPKCS7 pkcs7 = verifySignature(signUtil, name);
        System.out.println("Digest algorithm: " + pkcs7.getHashAlgorithm());
        System.out.println("Encryption algorithm: " + pkcs7.getEncryptionAlgorithm());
        System.out.println("Filter subtype: " + pkcs7.getFilterSubtype());
        X509Certificate cert = (X509Certificate) pkcs7.getSigningCertificate();
        System.out.println("Name of the signer: " + CertificateInfo.getSubjectFields(cert).getField("CN"));
        if (pkcs7.getSignName() != null)
            System.out.println("Alternative name of the signer: " + pkcs7.getSignName());
        SimpleDateFormat date_format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("Signed on: " + date_format.format(pkcs7.getSignDate().getTime()));
        if (pkcs7.getTimeStampDate() != null) {
            System.out.println("TimeStamp: " + date_format.format(pkcs7.getTimeStampDate().getTime()));
            TimeStampToken ts = pkcs7.getTimeStampToken();
            System.out.println("TimeStamp service: " + ts.getTimeStampInfo().getTsa());
            System.out.println("Timestamp verified? " + pkcs7.verifyTimestampImprint());
        }
        System.out.println("Location: " + pkcs7.getLocation());
        System.out.println("Reason: " + pkcs7.getReason());*/
        PdfDictionary sigDict = signUtil.getSignatureDictionary(name);
        PdfString contents = sigDict.getAsString(PdfName.Contents);
        if (contents != null)
            System.out.println("Contact info: " );

        CertificateFactory certificateFactory = new CertificateFactory();
        X509Certificate certificate = (X509Certificate) certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(contents.getValueBytes()));
        Principal subjectDN = certificate.getSubjectDN();
        System.out.println("subjectDN:" + subjectDN);
        System.out.println("IssuerDN:" + certificate.getIssuerDN());
        System.out.println("SerialNumber:" + certificate.getSerialNumber());
        System.out.println("SubjectCN:" + certificate.getIssuerDN());
        System.out.println("SigningTime:" + PdfDate.getW3CDate(sigDict.getAsString(PdfName.M).toString()));

        perms = new SignaturePermissions(sigDict, perms);
        System.out.println("Signature type: " + (perms.isCertification() ? "certification" : "approval"));
        System.out.println("Filling out fields allowed: " + perms.isFillInAllowed());
        System.out.println("Adding annotations allowed: " + perms.isAnnotationsAllowed());
        for (SignaturePermissions.FieldLock lock : perms.getFieldLocks()) {
            System.out.println("Lock: " + lock.toString());
        }
        return perms;
    }

    public PdfPKCS7 verifySignature(SignatureUtil signUtil, String name) throws GeneralSecurityException, IOException {
        System.out.println("Signature covers whole document: " + signUtil.signatureCoversWholeDocument(name));
        System.out.println("Document revision: " + signUtil.getRevision(name) + " of " + signUtil.getTotalRevisions());
        PdfPKCS7 pkcs7 = signUtil.verifySignature(name);
        System.out.println("Integrity check OK? " + pkcs7.verify());
        return pkcs7;
    }

    @Test
    public void test2() throws FileNotFoundException, CertificateException {
        String path = "D:\\wangchen\\tools/ks";
        FileInputStream is = new FileInputStream(path);
        CertificateFactory cf = new CertificateFactory();
        X509Certificate certificate = (X509Certificate) cf.engineGenerateCertificate(is);
        Principal subjectDN = certificate.getSubjectDN();
        System.out.println("subjectDN:" + subjectDN);
        System.out.println("IssuerDN:" + certificate.getIssuerDN());
        System.out.println("SerialNumber:" + certificate.getSerialNumber());
        System.out.println("SubjectCN:" + certificate.getIssuerDN());
    }

    @Test
    public void addNewPage(){
        String srcPath = "d:/tmp/hello.pdf";
        String destPath = "d:/tmp/signatures/2.pdf";
        try {
            PdfDocument pdfDocument = new PdfDocument(new PdfReader(srcPath), new PdfWriter(destPath));
            pdfDocument.addNewPage();
            pdfDocument.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3(){
        int i = 5/3;
        System.out.println(i);
    }
}
