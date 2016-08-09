package test.file

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord

/**
 * 
 * Columns
 * <pre>
 * 0	album artist
 * 1	artist
 * 2	album
 * 3	name
 * 4	bitrate
 * 5	file path
 * </pre>
 * 
 * @author gwmccort
 *
 */
class CommonsCsvTest {

	static main(args) {
		String fileName = "H:\\Project_Files\\github\\Mp3File\\bitrate.csv";
		Reader input = new FileReader(fileName);
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(input);
		for (CSVRecord record : records) {
			String columnOne = record.get(0);
			String path = record.get(5);
			System.out.println("commons path:" + path);
			println record
		}
	}

}
