package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfName;
import org.junit.Test;

/**
 * pdfName test
 *
 * @author WangChen
 * Created on 2019/7/16 17:33
 * @since 1.0
 */
public class PdfNameTest {

    @Test
    public void test() {
        showObject(PdfName.Contents);
        showObject(new PdfName("CustomName"));
        showObject(new PdfName("Test #1 100%"));
    }

    void showObject(PdfName obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> name? " + obj.isName());
        System.out.println("-> type: " + obj.getType());
//        System.out.println("-> bytes: " + new String(obj.getBytes()));
        System.out.println("-> toString: " + obj.toString());
    }
}
