package gwm.csv

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import au.com.bytecode.opencsv.CSVReader

class ConvertCsvToXslGroovy {

	static main(args) {
		CSVReader r = new CSVReader(new FileReader('x.csv'))

		XSSFWorkbook workBook = new XSSFWorkbook()
		XSSFSheet sheet = workBook.createSheet("sheet1")

//		def lines = r.readAll()
//		lines.each { line ->
//			line.each { cell ->
//				println cell
//			}
//		}

//		for (l in lines) {
//			l.each {
//				println it
//			}
//		}
	}

}
