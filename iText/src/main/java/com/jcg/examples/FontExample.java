package com.jcg.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class FontExample
{
		public static void main(String[] args) throws FileNotFoundException, DocumentException
		{
				Document document = new Document();
				@SuppressWarnings("unused")
				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
				document.open();
				
				Phrase phrase = new Phrase();
				Paragraph paragraph = new Paragraph();
				
				Font timesRomanfont = new Font(Font.FontFamily.TIMES_ROMAN,16,Font.BOLDITALIC);
				Chunk timesRomanChunk = new Chunk("Java Code Geeks",timesRomanfont);
				phrase.add(timesRomanChunk);
				phrase.add(Chunk.NEWLINE);
				
				Font strikeThruFont = new Font(Font.FontFamily.COURIER,20,Font.STRIKETHRU);
				Chunk strikeThruChunk = new Chunk("Strike Through",strikeThruFont);
				phrase.add(strikeThruChunk);
				phrase.add(Chunk.NEWLINE);
				
				Font underlineFont = new Font(Font.FontFamily.HELVETICA,20,Font.UNDERLINE);
				Chunk underlineChunk = new Chunk("This is underLined",underlineFont);
				phrase.add(underlineChunk);
				
				paragraph.add(phrase);
				paragraph.setAlignment(Element.ALIGN_CENTER);
				document.add(paragraph);
				
				document.close();
		}
		
}

