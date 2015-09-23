package com.jcg.examples;


import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class AddWaterMark
{
		public static void main(String[] args)
		{
				try
				{
						PdfReader pdfReader = new PdfReader("HelloWorld.pdf");
						PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("WaterMarked.pdf"));
						PdfContentByte content = pdfStamper.getUnderContent(1);

						Image background = Image.getInstance("src\\main\\resources\\JavaCodeGeeks-water3.png");
						
						background.setAbsolutePosition(150f, 650f);
						content.addImage(background);
						
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
