package com.jcg.examples.pdfwriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdf
{
		public static void main(String[] args) throws FileNotFoundException, DocumentException
		{
			Document document = new Document();
			@SuppressWarnings("unused")
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
			document.open();
			
			Paragraph paragraph = new Paragraph();
			paragraph.add("Hello World!");
			paragraph.setAlignment(Element.ALIGN_CENTER);
				
			Paragraph otherParagraph = new Paragraph();
			otherParagraph.add("Welcome to JCG!");
			otherParagraph.setAlignment(Element.ALIGN_CENTER);
				
			document.add(paragraph);
			document.add(otherParagraph);
			document.close();
		}
		
}
