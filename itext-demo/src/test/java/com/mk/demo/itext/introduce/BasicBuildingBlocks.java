package com.mk.demo.itext.introduce;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.ListItem;
import com.itextpdf.layout.element.Paragraph;
import org.junit.Test;

import java.io.IOException;

/**
 * basic building blocks (基本构件)
 *
 * @author WangChen
 * Created on 2019/7/16 20:49
 * @since 1.0
 */
public class BasicBuildingBlocks {

    @Test
    public void test() throws IOException {
        String dest = "src/main/resources/file/pdf/introduce/BasicBuildingBlocks.pdf";
        this.createPdf(dest);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        // Initialize document
        Document document = new Document(pdf);
        // Create a PdfFont
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        // Add a Paragraph
        Paragraph paragraph = new Paragraph("iText is:");
        paragraph.setFont(font);// iText always uses Helvetica as the default font for text content
        document.add(paragraph);
        // Create a List
        List list = new List()
                .setSymbolIndent(12) // be  indented by 12 user units
                .setListSymbol("\u2022") // •  a bullet list
                .setFont(font);
        // Add ListItem objects
        list.add(new ListItem("Never gonna give you up"))
                .add(new ListItem("Never gonna let you down"))
                .add(new ListItem("Never gonna run around and desert you"))
                .add(new ListItem("Never gonna make you cry"))
                .add(new ListItem("Never gonna say goodbye"))
                .add(new ListItem("Never gonna tell a lie and hurt you"));
        // Add the list
        document.add(list);
        //Close document
        document.close();
    }
}
