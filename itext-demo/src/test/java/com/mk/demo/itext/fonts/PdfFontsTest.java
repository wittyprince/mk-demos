package com.mk.demo.itext.fonts;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import com.itextpdf.layout.Canvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

/**
 * pdf fonts test
 *
 * @author WangChen
 * Created on 2019/4/17 12:09
 * @since
 */
public class PdfFontsTest {

    /**
     * 借助PdfFont, 使用不同字体
     */
    @Test
    public void test1() throws IOException {
        String dest = "d:/tmp/1.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
        PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
        PdfFont bold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
        Text title =
                new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
        Text author = new Text("Robert Louis Stevenson").setFont(font);
        Paragraph p = new Paragraph().add(title).add(" by ").add(author);
        document.add(p);
        document.close();
    }

    public static final String REGULAR =
            "src/main/resources/fonts/Cardo-Regular.ttf";
    public static final String BOLD =
            "src/main/resources/fonts/Cardo-Bold.ttf";
    public static final String ITALIC =
            "src/main/resources/fonts/Cardo-Italic.ttf";
    /**
     * 借助FontProgram, 使用不同字体
     */
    @Test
    public void test2() throws IOException {
        String dest = "d:/tmp/2.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);

        FontProgram fontProgram =
                FontProgramFactory.createFont(REGULAR);
        PdfFont font = PdfFontFactory.createFont(
                fontProgram, PdfEncodings.WINANSI, true);

        PdfFont bold = PdfFontFactory.createFont(BOLD, true);
        PdfFont italic = PdfFontFactory.createFont(ITALIC, true);

        Text title =
                new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
        Text author = new Text("Robert Louis Stevenson").setFont(font);
        Paragraph p = new Paragraph().setFont(italic)
                .add(title).add(" by ").add(author);
        document.add(p);
        document.close();
    }

    /**
     * 如果不适用embed模式内嵌字体，那么如果本地计算机中没有Cardo字体，查看时会被Adobe Sans MM字体代替.
     */
    @Test
    public void test3() throws IOException {
        String dest = "src/main/resources/file/pdf/3.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);

        FontProgram fontProgram =
                FontProgramFactory.createFont(REGULAR);
        PdfFont font = PdfFontFactory.createFont(
                fontProgram, PdfEncodings.WINANSI);

        PdfFont bold = PdfFontFactory.createFont(BOLD);
        PdfFont italic = PdfFontFactory.createFont(ITALIC);

        Text title =
                new Text("The Strange Case of Dr. Jekyll and Mr. Hyde").setFont(bold);
        Text author = new Text("Robert Louis Stevenson").setFont(font);
        Paragraph p = new Paragraph().setFont(italic)
                .add(title).add(" by ").add(author);
        document.add(p);
        document.close();
    }

    /**
     * 一个PdfFont对象只能被单个PdfDocument使用
     * Pdf indirect object belongs to other PDF document. Copy object to current pdf document.
     */
    @Test
    public void test4() throws IOException {
        String dest = "src/main/resources/file/pdf/4.pdf";
        File file = new File(dest);
        file.getParentFile().mkdirs();
        FontProgram fontProgram =
                FontProgramFactory.createFont(REGULAR);
        FontProgram boldProgram =
                FontProgramFactory.createFont(BOLD);
        FontProgram italicProgram =
                FontProgramFactory.createFont(ITALIC);
            font = PdfFontFactory.createFont(
                    fontProgram, PdfEncodings.WINANSI, true);
            bold = PdfFontFactory.createFont(
                boldProgram, PdfEncodings.WINANSI, true);
            italic = PdfFontFactory.createFont(
                italicProgram, PdfEncodings.WINANSI, true);
        for (int i = 0; i < 3; ) {
            createPdf(String.format(dest, ++i));
        }
    }
    protected PdfFont font;
    protected PdfFont bold;
    protected PdfFont italic;
    private void createPdf(String dest) throws IOException {
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
        Text title =
                new Text("The Strange Case of Dr. Jekyll and Mr. Hyde")
                        .setFont(bold);
        Text author = new Text("Robert Louis Stevenson")
                .setFont(font);
        Paragraph p = new Paragraph()
                .setFont(italic).add(title).add(" by ").add(author);
        document.add(p);
        document.close();
    }

    public static final String CZECH =
            "Podivn\u00fd p\u0159\u00edpad Dr. Jekylla a pana Hyda";
    public static final String RUSSIAN =
            "\u0421\u0442\u0440\u0430\u043d\u043d\u0430\u044f "
                    + "\u0438\u0441\u0442\u043e\u0440\u0438\u044f "
                    + "\u0434\u043e\u043a\u0442\u043e\u0440\u0430 "
                    + "\u0414\u0436\u0435\u043a\u0438\u043b\u0430 \u0438 "
                    + "\u043c\u0438\u0441\u0442\u0435\u0440\u0430 "
                    + "\u0425\u0430\u0439\u0434\u0430";
    public static final String KOREAN =
            "\ud558\uc774\ub4dc, \uc9c0\ud0ac, \ub098";
    public static final String FREESANS = "src/main/resources/fonts/FreeSans.ttf";
    public static final String HCRBATANG = "src/main/resources/fonts/HANBatang.ttf";

    /**
     * unicode编码
     */
    @Test
    public void test5() throws IOException {
        String dest = "src/main/resources/file/pdf/5.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
//        PdfFont font = PdfFontFactory.createFont(HCRBATANG, true);
//        document.add(new Paragraph().setFont(font)
//                .add(CZECH).add(" by Robert Louis Stevenson"));
//        document.add(new Paragraph().setFont(font)
//                .add(RUSSIAN).add(" by Robert Louis Stevenson"));
//        document.add(new Paragraph().setFont(font)
//                .add(KOREAN).add(" by Robert Louis Stevenson"));

        PdfFont font1250 = PdfFontFactory.createFont(FREESANS, PdfEncodings.CP1250, true);
        document.add(new Paragraph().setFont(font1250)
                .add(CZECH).add(" by Robert Louis Stevenson"));
        PdfFont font1251 = PdfFontFactory.createFont(FREESANS, "Cp1251", true);
        document.add(new Paragraph().setFont(font1251)
                .add(RUSSIAN).add(" by Robert Louis Stevenson"));
        PdfFont fontUnicode =
                PdfFontFactory.createFont(HCRBATANG, PdfEncodings.IDENTITY_H, true);
        document.add(new Paragraph().setFont(fontUnicode)
                .add(KOREAN).add(" by Robert Louis Stevenson"));
        document.close();
    }

    /**
     * Font Properties
     * font color
     */
    @Test
    public void test6() throws FileNotFoundException {
        String dest = "src/main/resources/file/pdf/6.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);
        Text title1 = new Text("The Strange Case of ").setFontColor(ColorConstants.BLUE);
        Text title2 = new Text("Dr. Jekyll")
                .setStrokeColor(ColorConstants.GREEN)
                .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.FILL_STROKE);
        Text title3 = new Text(" and ");
        Text title4 = new Text("Mr. Hyde")
                .setStrokeColor(ColorConstants.RED).setStrokeWidth(0.5f)
                .setTextRenderingMode(PdfCanvasConstants.TextRenderingMode.STROKE);
        Paragraph p = new Paragraph().setFontSize(24)
                .add(title1).add(title2).add(title3).add(title4);
        document.add(p);
        document.close();
    }

    /**
     *
     */
    @Test
    public void test7() throws IOException {
        String dest = "src/main/resources/file/pdf/7.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PdfFont defaultFont = pdf.getDefaultFont();
//        Arrays.stream(defaultFont.getFontMatrix()).forEach(System.out::println);
        String defaultFontName = defaultFont.getFontProgram().getFontNames().getFontName();
        System.out.println("defaultFontName:" + defaultFontName);
        PageSize defaultPageSize = pdf.getDefaultPageSize();
        Logger.getGlobal().info("defaultPageSize:" + defaultPageSize.getWidth()
                + ", left:" + defaultPageSize.getLeft()
                + ", right:" + defaultPageSize.getRight()
                + ", height:" + defaultPageSize.getHeight()
                + ", top:" + defaultPageSize.getTop()
                + ", bottom:" + defaultPageSize.getBottom());
        Document document = new Document(pdf);
        float leftMargin = document.getLeftMargin();
        float rightMargin = document.getRightMargin();
        float topMargin = document.getTopMargin();
        float bottomMargin = document.getBottomMargin();
        Logger.getGlobal().info(
            "leftMargin:" + leftMargin
            + "rightMargin:" + rightMargin
            + "topMargin:" + topMargin
            + "bottomMargin:" + bottomMargin);

        Rectangle pageEffectiveArea = document.getPageEffectiveArea(defaultPageSize);
        Logger.getGlobal().info("pageEffectiveArea:"
            + pageEffectiveArea.getWidth()
            +", " + pageEffectiveArea.getHeight()
            + ", " + pageEffectiveArea.getLeft()
            + ", "+ pageEffectiveArea.getRight()
            + ", " + pageEffectiveArea.getTop()
            + ", " + pageEffectiveArea.getBottom()
            + ", " + pageEffectiveArea.getX()
            + ", " + pageEffectiveArea.getY());

        PdfFont pdfFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);
        // IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        // WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW
        String text = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW";
        text = "W1\nW2\nW3\nW4\nW5\nW6\nW7\nW8\nW9\nW10\nW11\nW12\nW13\nW14\nW15\nW16\nW17\nW18\nW19\nW20\nW21\nW22\nW23\nW24\nW25\nW26\nW27\nW28\nW29\nW30\nW31\nW32\nW33\nW34\nW35\nW36\nW37\nW38\nW39" +
                "\nW40\n41\n42\n43\n44\n45\n46\n47\n48\n49\n50\n512\n52\n53\n54\n55\n56\n57\n58\n59\n60\n61\n62\n63\n64\n65\n66\n67\n68\n69\n70\n71\n72\n73\n74\n75";
        Paragraph p = new Paragraph(text).setFontSize(14).setFont(pdfFont);
        p.setMarginLeft(0).setMarginTop(0);
        System.out.println(p.getMarginLeft() + ", " + p.getMarginRight() + ", " + p.getMarginTop() + ", " + p.getMarginBottom());
        p.setMultipliedLeading(1);
        document.add(p);

        Rectangle rectangle = new Rectangle(72, 72, 200, 200);
        PdfCanvas pdfCanvas = new PdfCanvas(pdf.getFirstPage());
        Canvas canvas = new Canvas(pdfCanvas, pdf, rectangle);
        canvas.add(p);
        pdfCanvas.rectangle(rectangle);
//        pdfCanvas.setStrokeColor(ColorConstants.WHITE);
        pdfCanvas.stroke();

        document.close();
    }

    @Test
    public void test8() throws IOException {
        String s = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW\nW";
        s = "WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW";
        s = "a WHAT IS THE WIDTH OF THIS STRING?";
        s = "2019-04-22T20:00:08.171\n" +
                "+08:00[Asia/Shanghai]";
        PdfFont pdfFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H",true);
        float fontSize = 8;
        System.out.println("Width:" + pdfFont.getWidth(s, fontSize));
        int ascent = pdfFont.getAscent(s, fontSize);
        System.out.println("ascent:" + ascent);
        int descent = pdfFont.getDescent(s, fontSize);
        System.out.println("Descent:" + descent);
        System.out.println("height:" + (ascent - descent));

//        double w = pdfFont.getContentWidth(new PdfString(s)) * pdfFont.getFontMatrix()[0] * 16;
//        System.out.println("w:" + w);
//        BaseFont.getWidthPoint(s, 9);
        String[] split = s.split("\\s+");
//        Arrays.stream(split).forEach(System.out::println);
//        String text = "WHAT IS THE WIDTH OF THIS STRING?";
        float maxFontSize = this.getMaxFontSize(s, pdfFont, 7, new Rectangle(100, 100, 120, 28));
        System.out.println("maxFontSize:" + maxFontSize);

    }

    /**
     * 此方法并不能处理包含换行符(\n)的字符串
     * 需注意如果最后一个字符长度很长的情况, 如果前面的行没有写满, 可能会导致最后一个字符写不进rectangle
     * 考虑每行占满, 使用连字符的方法解决
     */
    private float getMaxFontSize(String text, PdfFont font, float minFontSize, Rectangle rect){
        String[] words = text.split("\\s+");
        for (String word : words){

        }
        float fontSize = minFontSize;
        for (int i = 0; ; i++){
            float width = font.getWidth(text, fontSize + i);
            double rowNum = Math.ceil(width / rect.getWidth());
            // 高度的最大占比为80%(未找到官方说明文档, 自己测试值), 这里取值70%
            if (rowNum * (fontSize + i)  >= rect.getHeight() * 0.70){
                if (i == 0){
                    fontSize = -1f;
                }else {
                    // -1
                    fontSize = fontSize + i - 1;
                }
                break;
            }
        }
        return fontSize;
    }

    @Test
    public void test9(){
        String text = "abc\n\nd";
        String[] p = text.split("\\n");
        Arrays.stream(p).forEach(System.out::println);
    }

    @Test
    public void test10() throws IOException {
        String text = "点击保存按钮可把当前接口保存到测试集，方便下次调试。";
        text = "2019-04-22T20:00:08.171\n" +
                "+08:00[Asia/Shanghai]";
        PdfFont pdfFont = PdfFontFactory.createFont("STSong-Light", "UniGB-UCS2-H", true);
        Rectangle rect = new Rectangle(200, 300, 120, 23);
        float maxFontSize = this.getMaxFontSize(text, pdfFont, 7, rect);
        System.out.println("maxFontSize:" + maxFontSize);

        String dest = "src/main/resources/file/pdf/10.pdf";
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        Document document = new Document(pdf);

        Paragraph p = new Paragraph(text).setFontSize(maxFontSize).setFont(pdfFont);
        p.setMarginLeft(0).setMarginTop(0);
        p.setMultipliedLeading(1);
        document.add(p);

        String[] words = text.split("\\s+");


        PdfCanvas pdfCanvas = new PdfCanvas(pdf.getFirstPage());
        Canvas canvas = new Canvas(pdfCanvas, pdf, rect);
        canvas.add(p);
        pdfCanvas.rectangle(rect);
//        pdfCanvas.setStrokeColor(ColorConstants.WHITE);
        pdfCanvas.stroke();

        document.close();
    }
}
