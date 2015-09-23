package com.jcg.examples;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;

public class ChunkExample
{
		public static void main(String[] args) throws FileNotFoundException, DocumentException
		{
				Document document = new Document();
				@SuppressWarnings("unused")
				PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
				document.open();
				
				for(int count = 0;count<10;count++)
				{
						Chunk chunk = new Chunk("Hello World!!");
						document.add(chunk);
				}
				
				document.close();
		}
		
}

