package com.jcg.examples.beginners;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class ParagraphExample
{
		public static void main(String[] args) throws FileNotFoundException, DocumentException
		{
				Document document = new Document();
				@SuppressWarnings("unused")
				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
				document.open();
				
				Paragraph paragraph1 = new Paragraph("This is Paragraph 1");
				Paragraph paragraph2 = new Paragraph("This is Paragraph 2");
				paragraph1.setIndentationLeft(80);
				paragraph1.setIndentationRight(80);
				paragraph1.setAlignment(Element.ALIGN_CENTER);
				paragraph1.setSpacingAfter(15);
				paragraph2.setSpacingBefore(15);
				paragraph2.setAlignment(Element.ALIGN_LEFT);
				Phrase phrase = new Phrase("This is a large sentence.");
				for(int count = 0;count<10;count++)
				{
						paragraph1.add(phrase);
						paragraph2.add(phrase);
				}
				
				document.add(paragraph1);
				document.add(paragraph2);
				
				document.close();
		}
		
}

