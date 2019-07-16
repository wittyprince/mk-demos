package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfBoolean;
import org.junit.Test;

/**
 * pdf object test
 *
 * @author WangChen
 * Created on 2019/7/16 11:14
 * @since 1.0
 */
public class PdfBooleanTest {


    @Test
    public void test1(){
        showObject(PdfBoolean.TRUE);
        showObject(PdfBoolean.FALSE);
    }

    /**
     * com.itextpdf.kernel.pdf.PdfBoolean:
     * -> boolean? true
     * -> type: 2
     * -> toString: true
     * -> booleanvalue: true
     * com.itextpdf.kernel.pdf.PdfBoolean:
     * -> boolean? true
     * -> type: 2
     * -> toString: false
     * -> booleanvalue: false
     */
    void showObject(PdfBoolean obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> boolean? " + obj.isBoolean());
        System.out.println("-> type: " + obj.getType());
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> booleanvalue: " + obj.getValue());
    }


}
