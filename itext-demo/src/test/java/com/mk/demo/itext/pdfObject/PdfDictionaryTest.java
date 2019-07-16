package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfBoolean;
import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfNull;
import com.itextpdf.kernel.pdf.PdfNumber;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.action.PdfAction;
import org.junit.Test;

/**
 * PdfDictionaryTest
 *
 * @author WangChen
 * Created on 2019/7/16 18:08
 * @since 1.0
 */
public class PdfDictionaryTest {

    @Test
    public void test() {
        PdfDictionary dict = new PdfDictionary();
        dict.put(new PdfName("Custom"), new PdfNull());
        dict.put(new PdfName("Entry1"), PdfName.First);
        dict.put(new PdfName("Entry2"), new PdfString("Second"));
        dict.put(new PdfName("3rd"), new PdfNumber(3));
        dict.put(new PdfName("Fourth"), PdfBoolean.FALSE);
        showObject(dict);
//        showObject(PdfAction.createGoToR("test.pdf", "dest", false));
    }

    void showObject(PdfDictionary obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> dictionary? " + obj.isDictionary());
        System.out.println("-> type: " + obj.getType());
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> size: " + obj.size());
        for (PdfName key : obj.keySet()) {
            System.out.print(" " + key + ": ");
            System.out.println(obj.get(key));
        }
    }
}
