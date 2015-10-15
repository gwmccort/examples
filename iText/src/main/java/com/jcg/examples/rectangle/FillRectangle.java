package com.jcg.examples.rectangle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class FillRectangle
{
		public static void main(String[] args)
		{
				try
				{
						Document document = new Document();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Rectangled.pdf"));
						document.open();
						PdfContentByte contentByte = writer.getDirectContent();
						contentByte.rectangle(186, 186, 159, 150);
						contentByte.setColorFill(BaseColor.CYAN);
						contentByte.fill();
						document.close();
				}
				catch (FileNotFoundException e)
				{
						e.printStackTrace();
				}
				catch (DocumentException e)
				{
						e.printStackTrace();
				}
		}
}
