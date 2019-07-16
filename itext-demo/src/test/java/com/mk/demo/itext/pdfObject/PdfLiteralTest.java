package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfLiteral;
import com.itextpdf.kernel.pdf.PdfObject;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import org.junit.Test;

/**
 * PdfLiteral test
 *
 * @author WangChen
 * Created on 2019/7/16 18:41
 * @since 1.0
 */
public class PdfLiteralTest {


    @Test
    public void test(){
//        showObject(PdfFormXObject.MATRIX);
        showObject(new PdfLiteral("<</Type/Custom/Contents [1 2 3]>>"));
    }

    void showObject(PdfObject obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> type: " + obj.getType());
//        System.out.println("-> bytes: " + new String(obj.getBytes()));
        System.out.println("-> toString: " + obj.toString());
    }

}
