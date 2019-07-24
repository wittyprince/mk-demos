package com.mk.demo.itext.interactive;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfBoolean;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.annot.PdfAnnotation;
import com.itextpdf.kernel.pdf.annot.PdfTextAnnotation;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * TextAnnotation
 *
 * @author WangChen
 * Created on 2019/7/24 18:35
 * @since 1.0
 */
public class TextAnnotationTest {

    public static final String DEST = "src/main/resources/file/pdf/interactive/TextAnnotationTest.pdf";

    @Test
    public void test() throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));

        //Initialize document
        Document document = new Document(pdf);
        document.add(new Paragraph("The example of text annotation."));

        //Create text annotation
        PdfAnnotation ann = new PdfTextAnnotation(new Rectangle(20, 800, 0, 0))
                .setColor(ColorConstants.GREEN)
                .setTitle(new PdfString("iText"))
                .setContents("With iText, you can truly take your documentation needs to the next level.")
                .put(PdfName.Open, PdfBoolean.valueOf(true));
        pdf.getFirstPage().addAnnotation(ann);

        //Close document
        document.close();

    }
}
