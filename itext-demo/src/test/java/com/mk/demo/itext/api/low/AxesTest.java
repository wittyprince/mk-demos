package com.mk.demo.itext.api.low;

import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.PdfCanvasConstants;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * canvas test
 *
 * @author WangChen
 * Created on 2019/7/16 22:05
 * @since 1.0
 */
public class AxesTest {

    public static final String DEST = "src/main/resources/file/pdf/api/low/CanvasTest.pdf";

    @Test
    public void test() throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        this.createPdf(DEST);
    }

    public void createPdf(String dest) throws IOException {
        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
        PageSize ps = PageSize.A4.rotate();
        PdfPage page = pdf.addNewPage(ps);
        PdfCanvas canvas = new PdfCanvas(page);
        // a b 0
        // c d 0
        // e f 1
        //Replace the origin of the coordinate system to the center of the page
        canvas.concatMatrix(1, 0, 0, 1, ps.getWidth() / 2, ps.getHeight() / 2);
        this.drawAxes(canvas, ps);
        //Close document
        pdf.close();
    }

    public void drawAxes(PdfCanvas canvas, PageSize ps) {
        //Draw X axis
        canvas.moveTo(-(ps.getWidth() / 2 - 15), 0)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .stroke();

        //Draw X axis arrow
        canvas.setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(ps.getWidth() / 2 - 25, -10)
                .lineTo(ps.getWidth() / 2 - 15, 0)
                .lineTo(ps.getWidth() / 2 - 25, 10).stroke()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.MITER);

        //Draw Y axis
        canvas.moveTo(0, -(ps.getHeight() / 2 - 15))
                .lineTo(0, ps.getHeight() / 2 - 15)
                .stroke();

        // a better practice should use whenever we change the graphics state: saveState and restoreState
        //Draw Y axis arrow
        canvas.saveState()
                .setLineJoinStyle(PdfCanvasConstants.LineJoinStyle.ROUND)
                .moveTo(-10, ps.getHeight() / 2 - 25)
                .lineTo(0, ps.getHeight() / 2 - 15)
                .lineTo(10, ps.getHeight() / 2 - 25).stroke()
                .restoreState();

        //Draw X serif
        for (int i = -((int) ps.getWidth() / 2 - 61); i < ((int) ps.getWidth() / 2 - 60); i += 40) {
            canvas.moveTo(i, 5).lineTo(i, -5);
        }
        //Draw Y serif
        for (int j = -((int) ps.getHeight() / 2 - 57); j < ((int) ps.getHeight() / 2 - 56); j += 40) {
            canvas.moveTo(5, j).lineTo(-5, j);
        }
        canvas.stroke();
    }
}
