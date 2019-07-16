package com.mk.demo.itext.introduce;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * form test
 *
 * @author WangChen
 * Created on 2019/7/16 21:21
 * @since 1.0
 */
public class FormTest {

    public static final String DATA = "src/main/resources/data/united_states.csv";
    public static final String DEST = "src/main/resources/file/pdf/introduce//FormTest2.pdf";

    @Test
    public void test() throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        this.createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        // Initialize document
        Document document = new Document(pdf, PageSize.A4.rotate());// rotate 顺时针旋转PageSize
        // By default iText uses a margin of 36 user units (half an inch)
        document.setMargins(20, 20, 20, 20);

        PdfFont font = PdfFontFactory.createFont(FontConstants.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.HELVETICA_BOLD);
        Table table = new Table(new float[]{4, 1, 3, 4, 3, 3, 3, 3, 1});// {4, 1, 3, 4, 3, 3, 3, 3, 1} table的相对宽度
//        table.setWidthPercent(100);
        table.setWidth(UnitValue.createPercentValue(100));
        BufferedReader br = new BufferedReader(new FileReader(DATA));
        String line = br.readLine();
        process(table, line, bold, true);
        while ((line = br.readLine()) != null) {
            process(table, line, font, false);
        }
        br.close();
        document.add(table);
        //Close document
        document.close();
    }

    public void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {// pdf会自动增加新页，如果分页，pdf会自动创建表头
                table.addHeaderCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            } else {
                table.addCell(new Cell().add(new Paragraph(tokenizer.nextToken()).setFont(font)));
            }
        }
    }
}
