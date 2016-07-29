package gwm.file;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVWriter;

public class OpenCSVWriterExample {

	public static void main(String[] args) throws IOException {
		StringWriter writer = new StringWriter();
		
		//using custom delimiter and quote character
		CSVWriter csvWriter = new CSVWriter(writer, '#', '\'');

		List<Employee> emps = OpenCSVParseToBeanExample.parseCSVWithHeader();

		List<String[]> data = toStringArray(emps);

		csvWriter.writeAll(data);

		csvWriter.close();
		
		System.out.println(writer);

	}

	private static List<String[]> toStringArray(List<Employee> emps) {
		List<String[]> records = new ArrayList<String[]>();

		// adding header record
		records.add(new String[] { "ID", "Name", "Age", "Country" });

		Iterator<Employee> it = emps.iterator();
		while (it.hasNext()) {
			Employee emp = it.next();
			records.add(new String[] { emp.getId(), emp.getName(), emp.getAge(), emp.getCountry() });
		}
		return records;
	}

}