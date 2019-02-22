package com.mk.demo.itext;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.signatures.*;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.*;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Security;
import java.security.cert.Certificate;

/**
 * test
 *
 * @author WangChen
 * Created on 2019/2/20 11:27
 * @since 1.0
 */
public class Test {

    @org.junit.Test
    public void test1() throws FileNotFoundException {
        PdfWriter writer = new PdfWriter("d:/tmp/tmp.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        document.add(new Paragraph("Hello World!"));
        document.close();
    }

    @org.junit.Test
    public void test2() throws IOException {
        PdfReader reader = new PdfReader("d:/tmp/tmp.pdf");
        PdfDocument pdf = new PdfDocument(reader);
        Document document = new Document(pdf);
        document.add(new Paragraph("wang"));
        document.close();
    }

    @org.junit.Test
    public void test3() throws IOException {
        InputStream src = new FileInputStream("d:/tmp/tmp2.pdf");
        String dest = "d:/tmp/tmp3.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src), new PdfWriter(dest));
//        pdfDoc.getFirstPage();
        // add content
        PdfPage page = pdfDoc.getPage(1);
        Rectangle rectangle = page.getPageSize();
        Rectangle mediaBox = page.getMediaBox();
        float height = mediaBox.getHeight();
        float width = mediaBox.getWidth();
        PdfCanvas canvas = new PdfCanvas(page);
//        canvas.rectangle(new Rectangle(0, 0, 20, 30));
        canvas.beginText()
                .setFontAndSize(PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
                .moveText(rectangle.getWidth() / 2 - 24, rectangle.getHeight() - 10)
                .showText("I want to the terms and conditions.")
                .endText();
        pdfDoc.close();
    }

    private void getOriginXY(Rectangle srcOrigin, String originPosition){

    }

    @org.junit.Test
    public void testSetOriginXY(){

    }

    @org.junit.Test
    public void test4() throws FileNotFoundException {
        String dest = "d:/tmp/t.pdf";
        PdfWriter writer = new PdfWriter(dest);
        PdfDocument pdf = new PdfDocument(writer);
    }

    @org.junit.Test
    public void test5() throws IOException {
        String dest = "d:/tmp/t.pdf";
        String src = "d:/tmp/tmp2.pdf";
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(src),new PdfWriter(dest));
        PageSize ps = pdfDoc.getDefaultPageSize();
        PdfFont font = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H",true);
        Text text = new Text("王晨This is the text added in the rectangle.");
//        text.setFont(font);
        Paragraph p = new Paragraph(text);
        p.setFont(font);
        p.add("another paragraph");
//        p.setBorder(new SolidBorder(1));
        PdfCanvas canvas = new PdfCanvas(pdfDoc.getFirstPage());
        Rectangle rect = new Rectangle(200, 550, 100, 100);
        new Canvas(canvas, pdfDoc, rect).add(p);
        canvas.rectangle(rect);
//        canvas.roundRectangle(200,550, 100, 100, 10);

        Rectangle rect2 = new Rectangle(205, 555, 50, 50);
        new Canvas(canvas, pdfDoc, rect2).add(p);
        canvas.rectangle(rect2);

//        canvas.setLineWidth(0f);
//        canvas.setLineDash(0f);
//        canvas.setLineCapStyle(0);

        canvas.setStrokeColor(ColorConstants.PINK);

        canvas.stroke();
//        canvas.fill();
        pdfDoc.close();
    }

    @org.junit.Test
    public void test6() throws KeyStoreException {
        Provider[] providers = Security.getProviders();
        KeyStore jks = KeyStore.getInstance("jks");
        String type = KeyStore.getDefaultType();
        KeyStore ks = KeyStore.getInstance(type);
        System.out.println(providers);
    }

    @org.junit.Test
    public void test7(){
        Paragraph paragraph = new Paragraph("完成wangc");
        paragraph.setFont("s");
        try {
            PdfFont pdfFont = PdfFontFactory.createFont();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
