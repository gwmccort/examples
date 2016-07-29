package gwm.file;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;

public class OpenCSVParseToBeanExample {

	public static void main(String[] args) throws IOException {

		CSVReader reader = new CSVReader(new FileReader("emps.csv"), ',');

		ColumnPositionMappingStrategy<Employee> beanStrategy = new ColumnPositionMappingStrategy<Employee>();
		beanStrategy.setType(Employee.class);
		beanStrategy.setColumnMapping(new String[] { "id", "name", "age", "country" });

		CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();

		List<Employee> emps = csvToBean.parse(beanStrategy, reader);

		System.out.println(emps);

	}
	
	public static List<Employee> parseCSVWithHeader() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("emps1.csv"), ',');
		
		HeaderColumnNameMappingStrategy<Employee> beanStrategy = new HeaderColumnNameMappingStrategy<Employee>();
		beanStrategy.setType(Employee.class);
		
		CsvToBean<Employee> csvToBean = new CsvToBean<Employee>();
		List<Employee> emps = csvToBean.parse(beanStrategy, reader);
		
		System.out.println(emps);
		reader.close();
		
		return emps;
	}
}