package com.jcg.examples.pdfwriter;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


public class PdfEncrytpion
{
		public static void main(String[] args)
		{
				try
				{
						Document document = new Document();
						PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("HelloWorldEncrypt.pdf"));
						pdfWriter.setEncryption("userpw".getBytes(), "ownerpw".getBytes(), PdfWriter.ALLOW_ASSEMBLY, PdfWriter.ENCRYPTION_AES_256);
						document.open();

						Paragraph paragraph = new Paragraph();
						paragraph.add("Hello World!");

						document.add(paragraph);
						document.close();
				}
				catch (FileNotFoundException | DocumentException e)
				{
						e.printStackTrace();
				}
		}

}

