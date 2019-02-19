package com.mk.demo.itext;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.TextAlignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * ITextHelloWorld
 *
 * @author WangChen
 * Created on 2019/2/19 10:35
 * @since 1.0
 */
public class ITextHelloWorld {

    public static final String TEXT = "D:/tmp/1.txt";
    public static final String DEST = "D:/tmp/DEST.pdf";
    public static final String SRC = "D:/tmp/SRC.pdf";

    public static void main(String args[]) throws Exception {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new ITextHelloWorld().manipulatePdf(DEST);
    }

    protected void manipulatePdf(String dest) throws Exception {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(SRC), new PdfWriter(DEST));
        PdfPage page = pdfDoc.getFirstPage();
        PdfDictionary dict = page.getPdfObject();
        PdfObject object = dict.get(PdfName.Contents);
        if (object instanceof PdfStream) {
            PdfStream stream = (PdfStream) object;
            byte[] data = stream.getBytes();
            StringBuffer stringBuffer = new StringBuffer(new String(data).replace("Hello World", "HELLO 王"));
//            stringBuffer.append("appended context");
            stream.setData(stringBuffer.toString().getBytes("UTF-8"));//new String(data).replace("Hello World", "HELLO WORLD1").getBytes("UTF-8")
//            stream.setData("haha".getBytes());
        }
        pdfDoc.close();
    }

    public void createPdf(String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf)
                .setTextAlignment(TextAlignment.JUSTIFIED);
        BufferedReader br = new BufferedReader(new FileReader(TEXT));
        String line;
        PdfFont normal = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        boolean title = true;
        while ((line = br.readLine()) != null) {
            document.add(new Paragraph(line).setFont(title ? bold : normal));
            title = line.isEmpty();
        }
        document.add(new Paragraph("Hello World!3"));
        document.close();
    }
}
