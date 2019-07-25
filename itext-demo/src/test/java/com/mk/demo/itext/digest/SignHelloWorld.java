package com.mk.demo.itext.digest;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.signatures.BouncyCastleDigest;
import com.itextpdf.signatures.DigestAlgorithms;
import com.itextpdf.signatures.IExternalDigest;
import com.itextpdf.signatures.IExternalSignature;
import com.itextpdf.signatures.PdfSignatureAppearance;
import com.itextpdf.signatures.PdfSigner;
import com.itextpdf.signatures.PrivateKeySignature;
import com.mk.demo.itext.C2_01_SignHelloWorld;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import java.io.File;
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
 * Created on 2019/7/25 11:56
 * @since 1.0
 */
public class SignHelloWorld {

//    public static final String KEYSTORE = "D:\\wangchen\\tools/msb.p12";//"D:\\wangchen\\tools/abchinablue.jks";//"D:\\wangchen\\tools/ks";//
//    public static final char[] PASSWORD = "Abcd!234".toCharArray();//"!QAZxsw2".toCharArray();//"password".toCharArray();//
//    public static final String SRC = "D:\\tmp/hello.pdf";
//    public static final String DEST = "D:\\tmp/signatures/hello_signed%s.pdf";

    public static final String KEYSTORE = "src/main/resources/encryption/abchinablue.jks";
    public static final char[] PASSWORD = "!QAZxsw2".toCharArray();
    public static final String SRC = "src/main/resources/file/pdf/hello.pdf";
    public static final String DEST = "src/main/resources/file/pdf/digest/hello_signed%s.pdf";

    @Test
    public void test() throws Exception{
        BouncyCastleProvider provider = new BouncyCastleProvider();
        Security.addProvider(provider);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(new FileInputStream(KEYSTORE), PASSWORD);
        String alias = ks.aliases().nextElement();
        PrivateKey pk = (PrivateKey) ks.getKey(alias, PASSWORD);
        Certificate[] chain = ks.getCertificateChain(alias);
        SignHelloWorld app = new SignHelloWorld();
        for (int i=1; i<5; i++){

        }
        String dest1 = String.format(DEST, 1);
        File file = new File(dest1);
        file.getParentFile().mkdirs();
        app.sign(SRC, dest1, chain, pk, DigestAlgorithms.SHA256, provider.getName(),
                PdfSigner.CryptoStandard.CMS, "Test 1", "Asia/Shanghai");
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
