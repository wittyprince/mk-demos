package com.mk.demo.itext;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * hello world test
 *
 * @author WangChen
 * Created on 2019/7/16 20:27
 * @since 1.0
 */
public class HelloWorldTest {

    @Test
    public void test() throws FileNotFoundException {
        String dest = "src/main/resources/file/pdf/hello.pdf";
        File file = new File(dest);
        file.getParentFile().mkdirs();
        OutputStream fos = new FileOutputStream(dest);// create a PDF file on disk
        // OutputStream fos = new ByteArrayOutputStream(dest);// create a PDF document in memory
        // OutputStream fos = new ServletOutputStream(dest);//  write a web application
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(fos);// PdfWriter is an object that can write a PDF file. It doesn’t know much about the actual content of the PDF document it is writing.
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);// The PdfWriter listens to a PdfDocument
        // Initialize document
        Document document = new Document(pdf);// high level object
        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));
        //Close document
        document.close();
    }
}
