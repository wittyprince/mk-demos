package com.mk.demo.itext.interactive;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * FillForm
 *
 * @author WangChen
 * Created on 2019/7/24 20:47
 * @since 1.0
 */
public class FillFormTest {

    public static final String SRC = "src/main/resources/file/pdf/interactive/AcroFormTest.pdf";
    public static final String DEST = "src/main/resources/file/pdf/interactive/FillFormTest.pdf";

    @Test
    public void test() throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        manipulatePdf(SRC, DEST);
    }

    public void manipulatePdf(String src, String dest) throws IOException {

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(new PdfReader(src), new PdfWriter(dest));


        PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
        Map<String, PdfFormField> fields = form.getFormFields();
        fields.get("name").setValue("James Bond");
        fields.get("language").setValue("English");
        fields.get("experience1").setValue("Off");
        fields.get("experience2").setValue("Yes");
        fields.get("experience3").setValue("Yes");
        fields.get("shift").setValue("Any");
        fields.get("info").setValue("I was 38 years old when I became an MI6 agent.");

        pdf.close();

    }
}
