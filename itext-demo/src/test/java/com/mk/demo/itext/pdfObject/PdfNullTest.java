package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfNull;
import org.junit.Test;

/**
 * PdfNull test
 *
 * @author WangChen
 * Created on 2019/7/16 18:30
 * @since 1.0
 */
public class PdfNullTest {

    @Test
    public void test() {
        showObject(PdfNull.PDF_NULL);
    }

    void showObject(PdfNull obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> type: " + obj.getType());
//        System.out.println("-> bytes: " + new String(obj.getBytes()));
        System.out.println("-> toString: " + obj.toString());
    }
}
