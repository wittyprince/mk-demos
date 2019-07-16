package com.mk.demo.itext.pdfObject;

import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfStream;
import org.junit.Test;

/**
 * PdfStream test
 *
 * @author WangChen
 * Created on 2019/7/16 18:19
 * @since 1.0
 */
public class PdfStreamTest {

    @Test
    public void test() {
        PdfStream stream = new PdfStream(
                "Long stream of data stored in a FlateDecode compressed stream object".getBytes(),
                9);
        int compressionLevel = stream.getCompressionLevel();
        System.out.println(compressionLevel);
        showObject(stream);
    }

    void showObject(PdfStream obj) {
        System.out.println(obj.getClass().getName() + ":");
        System.out.println("-> stream? " + obj.isStream());
        System.out.println("-> type: " + obj.getType());
        System.out.println("-> toString: " + obj.toString());
        System.out.println("-> raw length: " + obj.getLength());
        System.out.println("-> size: " + obj.size());
        for (PdfName key : obj.keySet()) {
            System.out.print(" " + key + ": ");
            System.out.println(obj.get(key));
        }
    }
}
