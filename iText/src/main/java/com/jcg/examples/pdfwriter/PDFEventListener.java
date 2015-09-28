package com.jcg.examples.pdfwriter;


import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;


public class PDFEventListener extends PdfPageEventHelper
{

		@Override
		public void onEndPage(PdfWriter writer, Document document)
		{
				try
				{
					Image background = Image.getInstance("src\\main\\resources\\JavaCodeGeeks-water3.png");
					float width = background.getWidth();
					float height = background.getHeight();
					writer.getDirectContentUnder().addImage(background, width, 0, 0, height, 0, 0);
				}
				catch (BadElementException e)
				{
					e.printStackTrace();
				}
				catch (MalformedURLException e)
				{
					e.printStackTrace();
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
