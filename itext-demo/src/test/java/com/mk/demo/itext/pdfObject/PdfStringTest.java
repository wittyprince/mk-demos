package com.mk.demo.itext.pdfObject;

import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.pdf.PdfDate;
import com.itextpdf.kernel.pdf.PdfString;
import org.junit.Test;

/**
 * pdf string test
 *
 * @author WangChen
 * Created on 2019/7/16 17:23
 * @since 1.0
 */
public class PdfStringTest {

    @Test
    public void test(){
        PdfString s1 = new PdfString("Test");
        PdfString s2 = new PdfString("\u6d4b\u8bd5", PdfEncodings.UTF8);
        showObject(s1);
        showObject(s2);
        s1.setHexWriting(true);
        showObject(s1);
//        showObject(new PdfDate());
    }

    public static void showObject(PdfString obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> string? " + obj.isString());
        System.out.println("-> type: " + obj.getType());
//        System.out.println("-> bytes: " + new String(obj.getBytes()));
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> hexWriting: " + obj.isHexWriting());
        System.out.println("-> encoding: " + obj.getEncoding());
//        System.out.println("-> bytes: " + new String(obj.getOriginalBytes()));
        System.out.println("-> unicode string: " + obj.toUnicodeString());
    }
}
