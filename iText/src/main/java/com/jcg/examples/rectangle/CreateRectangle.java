package com.jcg.examples.rectangle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class CreateRectangle
{
		public static void main(String[] args)
		{
				try
				{
						Document document = new Document();
						PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Rectagled.pdf"));
						document.open();
 
						PdfContentByte contentByte = writer.getDirectContent();
						Rectangle rectangle = new Rectangle(36, 36, 559, 806);
						rectangle.setBorder(Rectangle.BOX);
						contentByte.setColorStroke(BaseColor.BLACK);
						rectangle.setBorderWidth(2);
						contentByte.rectangle(rectangle);
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
