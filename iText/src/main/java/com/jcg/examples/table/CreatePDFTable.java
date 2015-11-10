package com.jcg.examples.table;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDFTable {
	public static void main(String[] args) {
		Document document = new Document();
		try {
			@SuppressWarnings("unused")
			PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream("CreateTable.pdf"));
			document.open();

			PdfPTable pdfPTable = new PdfPTable(2);
			PdfPCell pdfCell1 = new PdfPCell(new Phrase("Cell-1"));
			PdfPCell pdfCell2 = new PdfPCell(new Phrase("Cell-12"));
			pdfPTable.addCell(pdfCell1);
			pdfPTable.addCell(pdfCell2);
			PdfPCell pdfCell3 = new PdfPCell(new Phrase("Cell-21"));
			pdfCell3.setColspan(2);
			pdfCell3.setBackgroundColor(BaseColor.DARK_GRAY);
			pdfCell3.setBorderColor(BaseColor.RED);
			pdfCell3.setRotation(90);
			pdfPTable.addCell(pdfCell3);

			pdfPTable.setWidthPercentage(70);

			document.add(pdfPTable);
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		document.open();
	}
}