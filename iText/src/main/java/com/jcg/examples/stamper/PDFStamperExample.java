package com.jcg.examples.stamper;


import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


class PDFStamperExample
{
		public static void main(String[] args)
		{
				try
				{
						PdfReader pdfReader = new PdfReader("HelloWorld.pdf");
						PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("HelloWorldStamped.pdf"));
						PdfContentByte canvas = pdfStamper.getOverContent(1);
						ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, new Phrase("Hello from stamper!"), 250, 750, 0);
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
