package com.mk.demo.itext.introduce;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * image test
 *
 * @author WangChen
 * Created on 2019/7/16 21:05
 * @since 1.0
 */
public class ImageTest {

    private final String DOG = "src/main/resources/img/dog.bmp";
    private final String FOX = "src/main/resources/img/fox.bmp";

    @Test
    public void test() throws IOException {
        String dest = "src/main/resources/file/pdf/introduce/ImageTest.pdf";
        File file = new File(dest);
        file.getParentFile().mkdirs();
        this.createPdf(dest);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        // Initialize document
        Document document = new Document(pdf);

        // Compose Paragraph
        Image fox = new Image(ImageDataFactory.create(FOX));// jpg, png, gif. bmp,…
        Image dog = new Image(ImageDataFactory.create(DOG));
        Paragraph p = new Paragraph("The quick brown ")
                .add(fox)
                .add(" jumps over the lazy ")
                .add(dog);
        // Add Paragraph to document
        document.add(p);
        //Close document
        document.close();
    }
}
