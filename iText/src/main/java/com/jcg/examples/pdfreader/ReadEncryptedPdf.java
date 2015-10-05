package com.jcg.examples.pdfreader;


import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;


public class ReadEncryptedPdf
{
		public static void main(String[] args)
		{

				try
				{
						byte[] ownerPassword = "ownerpw".getBytes();
						PdfReader pdfReader = new PdfReader("HelloWorldEncrypt.pdf", ownerPassword);
						System.out.println("Is the PDF Encrypted " + pdfReader.isEncrypted());
						System.out.println("File is opened with full permissions : " + pdfReader.isOpenedWithFullPermissions());
						System.out.println("File length is : " + pdfReader.getFileLength());

						pdfReader.close();
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}

		}
}
