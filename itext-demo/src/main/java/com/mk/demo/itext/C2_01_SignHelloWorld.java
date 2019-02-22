package com.mk.demo.itext;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.Certificate;

/**
 * SignHelloWorld
 *
 * @author WangChen
 * Created on 2019/2/21 11:02
 * @since 1.0
 */
public class C2_01_SignHelloWorld {

    public static final String KEYSTORE = "D:\\wangchen\\tools/ks";//"D:\\wangchen\\tools/abchinablue.jks";//
    public static final char[] PASSWORD = "password".toCharArray();//"!QAZxsw2".toCharArray();//
    public static final String SRC = "D:\\tmp/hello.pdf";
    public static final String DEST = "D:\\tmp/signatures/hello_signed%s.pdf";

    public static void main(String[] args) throws Exception{
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(new FileInputStream(KEYSTORE), PASSWORD);
        String alias = ks.aliases().nextElement();
        PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
        Certificate[] chain = ks.getCertificateChain(alias);
        C2_01_SignHelloWorld app = new C2_01_SignHelloWorld();
        app.sign(SRC, String.format(DEST, 1), chain, pk, DigestAlgorithms.SHA256, provider.getName(),
                PdfSigner.CryptoStandard.CMS, "Test 1", "Ghent");
        app.sign(SRC, String.format(DEST, 2), chain, pk, DigestAlgorithms.SHA512, provider.getName(),
                PdfSigner.CryptoStandard.CMS, "Test 2", "Ghent");
        app.sign(SRC, String.format(DEST, 3), chain, pk, DigestAlgorithms.SHA256, provider.getName(),
                PdfSigner.CryptoStandard.CADES, "Test 3", "Ghent");
        app.sign(SRC, String.format(DEST, 4), chain, pk, DigestAlgorithms.RIPEMD160, provider.getName(),
                PdfSigner.CryptoStandard.CADES, "Test 4", "Ghent");
    }

    public void sign(String src, String dest,
                     Certificate[] chain,
                     PrivateKey pk, String digestAlgorithm, String provider,
                     PdfSigner.CryptoStandard subfilter,
                     String reason, String location)
            throws GeneralSecurityException, IOException {

        // Creating the reader and the signer
        PdfReader reader = new PdfReader(src);
        PdfSigner signer = new PdfSigner(reader, new FileOutputStream(dest), false);
        // Creating the appearance
        signer.setFieldName("001");
        PdfSignatureAppearance appearance = signer.getSignatureAppearance();
        String fieldName = signer.getFieldName();
        System.out.println("fieldName:" + fieldName);
        boolean invisible = appearance.isInvisible();
        System.out.println(invisible);
        appearance.setReason(reason)
                .setLocation(location)
//                .setLocationCaption(null)
                .setReuseAppearance(false);
        Rectangle rect = new Rectangle(36, 648, 200, 100);
        appearance
                .setPageRect(rect)
                .setPageNumber(1);
//        signer.setFieldName("Signature1");
        System.out.println(signer.getFieldName());
        // Creating the signature
        IExternalSignature pks = new PrivateKeySignature(pk, digestAlgorithm, provider);
        IExternalDigest digest = new BouncyCastleDigest();
        signer.signDetached(digest, pks, chain, null, null, null, 0, subfilter);
    }
}
