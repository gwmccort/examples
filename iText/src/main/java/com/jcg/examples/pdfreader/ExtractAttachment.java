package com.jcg.examples.pdfreader;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;


public class ExtractAttachment
{

		private static final String FILE_NAME = "PdfWithAttachment.pdf";

		public static void main(String[] args)
		{
				try
				{
						PdfReader pdfReader = new PdfReader(FILE_NAME);
						PdfDictionary catalog = pdfReader.getCatalog();

						// print catalog
						System.out.println(catalog + " type:" + catalog.type());
						System.out.println("catalog keys:");
						Set<PdfName> keys = catalog.getKeys();
						for (PdfName key : keys) {
							System.out.println("\t" + key);
						}
						
						PdfDictionary names = catalog.getAsDict(PdfName.NAMES);
						
						// print names
						System.out.println(names);
						System.out.println("names keys:");
						keys = catalog.getKeys();
						for (PdfName key : keys) {
							System.out.println("\t" + key);
						}
						
						PdfDictionary embeddedFiles = names.getAsDict(PdfName.EMBEDDEDFILES);
						PdfArray embeddedFilesArray = embeddedFiles.getAsArray(PdfName.NAMES);
						extractFiles(pdfReader, embeddedFilesArray);
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}
		}

		private static void extractFiles(PdfReader pdfReader, PdfArray filespecs)
		{
				PdfDictionary files = filespecs.getAsDict(1);
				PdfDictionary refs = files.getAsDict(PdfName.EF);
				PRStream prStream = null;
				FileOutputStream outputStream = null;
				String filename = "";
				Set<PdfName> keys= refs.getKeys();
				try
				{
						for (PdfName key : keys)
						{
								prStream = (PRStream) PdfReader.getPdfObject(refs.getAsIndirectObject(key));
								filename = files.getAsString(key).toString();
								filename = "Extracted" + filename;
								outputStream = new FileOutputStream(new File(filename));
								outputStream.write(PdfReader.getStreamBytes(prStream));
								outputStream.flush();
								outputStream.close();
						}
				}
				catch (FileNotFoundException e)
				{
						e.printStackTrace();
				}
				catch (IOException e)
				{
						e.printStackTrace();
				}
				finally
				{
						try
						{
								if (outputStream != null)
										outputStream.close();
						}
						catch (IOException e)
						{
								e.printStackTrace();
						}
				}
		}
}
