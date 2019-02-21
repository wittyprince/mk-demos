package com.mk.demo.itext;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.xobject.PdfFormXObject;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

/**
 * SuperImpose
 *
 * @author WangChen
 * Created on 2019/2/19 14:19
 * @since
 */
public class SuperImpose {

    public static final String DEST =
            "d:/tmp/super_impose.pdf";
    public static final String[] EXTRA = {
            "d:/tmp/1.pdf",
            "d:/tmp/2.pdf",
            "d:/tmp/3.pdf"
    };
    public static final String SRC =
            "d:/tmp/primes.pdf";

    public static void main(String[] args) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new SuperImpose().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(dest));
        PdfDocument srcDoc;
        PdfFormXObject page;
        PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage().newContentStreamBefore(),
                pdfDoc.getFirstPage().getResources(), pdfDoc);
        /*for (String path : EXTRA) {
            srcDoc = new PdfDocument(new PdfReader(path));
            page = srcDoc.getFirstPage().copyAsFormXObject(pdfDoc);
            canvas.addXObject(page, 0, 0);
            srcDoc.close();
        }*/

        srcDoc = null;
        page = srcDoc.getFirstPage().copyAsFormXObject(pdfDoc);
        canvas.addXObject(page, 10, 10);
        srcDoc.close();


        pdfDoc.close();
    }

}
