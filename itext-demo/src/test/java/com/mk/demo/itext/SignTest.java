package com.mk.demo.itext;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.StampingProperties;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.CertificateUtil;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.ITSAClient;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;
import com.itextpdf.signatures.TSAClientBouncyCastle;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Security;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
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

}
