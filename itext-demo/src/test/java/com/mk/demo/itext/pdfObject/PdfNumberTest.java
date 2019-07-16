package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfNumber;
import org.junit.Test;

/**
 * pdf number test
 *
 * @author WangChen
 * Created on 2019/7/16 16:56
 * @since 1.0
 */
public class PdfNumberTest {

    @Test
    public void test() {
        showObject(new PdfNumber("1.5".getBytes()));
        showObject(new PdfNumber(100));
        showObject(new PdfNumber(100L));
        showObject(new PdfNumber(1.5));
        showObject(new PdfNumber(1.5f));
    }

    /**
     * com.itextpdf.kernel.pdf.PdfNumber:
     * -> number? true
     * -> type: 8
     * -> bytes: 1.5
     * -> toString: 1.5
     * -> intValue: 1
     * -> longValue: 1
     * -> doubleValue: 1.5
     * -> floatValue: 1.5
     * com.itextpdf.kernel.pdf.PdfNumber:
     * -> number? true
     * -> type: 8
     * -> bytes: 100.0
     * -> toString: 100
     * -> intValue: 100
     * -> longValue: 100
     * -> doubleValue: 100.0
     * -> floatValue: 100.0
     */
    void showObject(PdfNumber obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> number? " + obj.isNumber());
        System.out.println("-> type: " + obj.getType());
//        System.out.println("-> bytes: " + new String(obj.getBytes()));
        System.out.println("-> bytes: " + String.valueOf(obj.getValue()));
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> intValue: " + obj.intValue());
        System.out.println("-> longValue: " + obj.longValue());
        System.out.println("-> doubleValue: " + obj.doubleValue());
        System.out.println("-> floatValue: " + obj.floatValue());
    }
}
