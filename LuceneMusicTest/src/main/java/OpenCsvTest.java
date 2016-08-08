import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import au.com.bytecode.opencsv.CSVReader;

/**
 * Test why opencsv eats windows path seperators.
 * 
 * <p>Bug report: https://sourceforge.net/p/opencsv/bugs/125/
 * 
 * <p>1.7 version doesn't have problem
 * 
 * <p>commons-csv works also
 * 
 * @author gwmccort
 *
 */
public class OpenCsvTest {

	public static void main(String[] args) throws Exception {
		String fileName = "H:\\Project_Files\\github\\Mp3File\\bitrate.csv";

//		// user opencsv to read file
//		CSVReader reader = new CSVReader(new FileReader(fileName));
////		CSVReader reader = new CSVReader(new FileReader(in), ',', '"', true);
//		String[] nextLine;
//		while ((nextLine = reader.readNext()) != null) {
//			System.out.println(nextLine[5]);
//		}
//		reader.close();
		
//		// use commons-csv to read file
//		Reader in = new FileReader(fileName);
//		Iterable<CSVRecord> records = CSVFormat.RFC4180.parse(in);
//		for (CSVRecord record : records) {
//		    String columnOne = record.get(0);
//		    String path = record.get(5);
//		    System.out.println("commons path:" + path);
//		}
		
		// user commons-csv to write file
		BufferedWriter writer = new BufferedWriter(new FileWriter("commons-csv.csv"));
//	    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
	    CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.EXCEL);
	    
//	    String[] sa = {"one", "two"};
//	    List<String> rec = Arrays.asList(sa);
	    List<String> rec = Arrays.asList( new String[]{"abc", "def"} );
	    csvPrinter.printRecord(rec);
	    rec = Arrays.asList( new String[]{"one", "two", "with \"quote\" imbedded", "c:\\windows\\path"} );
	    csvPrinter.printRecord(rec);
	    csvPrinter.close();
		
	}

}
