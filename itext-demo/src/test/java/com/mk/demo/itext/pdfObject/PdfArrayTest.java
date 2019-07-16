package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfBoolean;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfNumber;
import com.itextpdf.kernel.pdf.PdfString;
import org.junit.Test;

/**
 * PdfArray test
 *
 * @author WangChen
 * Created on 2019/7/16 17:56
 * @since 1.0
 */
public class PdfArrayTest {

    @Test
    public void test() {
        PdfArray array = new PdfArray();
        array.add(PdfName.First);
        array.add(new PdfString("Second"));
        array.add(new PdfNumber(3));
        array.add(PdfBoolean.FALSE);
        showObject(array);
        // showObject(new Rectangle(595, 842));
    }

    public static void showObject(PdfArray obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> array? " + obj.isArray());
        System.out.println("-> type: " + obj.getType());
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> size: " + obj.size());
        System.out.print("-> Values:");
        for (int i = 0; i < obj.size(); i++) {
            System.out.print(" ");
            System.out.print(obj.get(i));
        }
        System.out.println();
    }
}
