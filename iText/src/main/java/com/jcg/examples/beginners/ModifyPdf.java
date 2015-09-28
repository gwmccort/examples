package com.jcg.examples.beginners;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ModifyPdf
{
public static void main(String[] args)
{
		try
		{
				PdfReader pdfReader = new PdfReader("HelloWorld.pdf");
				PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorldModified.pdf"));
				PdfContentByte content = pdfStamper.getUnderContent(1);

				BaseFont bf = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.CP1250, BaseFont.EMBEDDED);
        content.beginText();
        content.setFontAndSize(bf, 18);
        content.showTextAligned(PdfContentByte.ALIGN_CENTER, "JavaCodeGeeks", 250,590,0);
        content.endText();
		
				pdfStamper.close();
				pdfReader.close();
		}
		catch (IOException e)
		{
				e.printStackTrace();
		}
		catch (DocumentException e)
		{
				e.printStackTrace();
		}

}
}
