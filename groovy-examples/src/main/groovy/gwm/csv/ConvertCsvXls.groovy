package gwm.csv

import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import au.com.bytecode.opencsv.CSVReader

/**
 * Convert csv files to xsl
 *
 * @see <a href="http://martinmihal.blogspot.com/2014/10/convert-csv-to-xlsxlsx-using-apache-poi.html">java example</a>
 *
 * @author gwmccort
 *
 */
public class ConvertCsvXls {

	public static void main(String[] args) {

		CSVReader reader = null;
		FileOutputStream fileOutputStream = null;

		System.out.println("Type name of CSV file for conversion." +
				"\nFile must be in same folder as \"CSV_to_XLSX.exe\":\n");

		//csv file name
		Scanner sc = new Scanner(System.in);
		String input_file = sc.next();

		//xls file name
		String xlsxFileAddress = null;
		if(input_file.length() < 5){
			System.out.println("Incorrect file name!");
			System.exit(0);
		} else {
			xlsxFileAddress = input_file.substring(0, input_file.length() - 4)+".xlsx";
		}

		try {
			//Get the CSVReader instance with specifying the delimiter to be used
			String[] nextLine;
//			reader = new CSVReader(new FileReader(input_file),',');
			reader = new CSVReader(new FileReader(input_file));

			XSSFWorkbook workBook = new XSSFWorkbook();
			XSSFSheet sheet = workBook.createSheet("sheet1");

			int RowNum=0;
			while ((nextLine = reader.readNext()) != null)
			{
				XSSFRow currentRow=sheet.createRow(RowNum++);
				for(int i=0;i<nextLine.length;i++){
					currentRow.createCell(i).setCellValue(nextLine[i]);
				}
			}

			fileOutputStream = new FileOutputStream(xlsxFileAddress);
			workBook.write(fileOutputStream);
		}
		catch (Exception e1) {
			e1.printStackTrace();
			System.out.println("Working Directory = " +
				System.getProperty("user.dir"));

			System.out.println("\nFile \"" + input_file + "\" does not exist!");
		}
		finally {
			if (reader != null) {
				try {
					reader.close();
					fileOutputStream.close();
					System.out.println("Done");
				} catch (IOException e2) {
					//e2.printStackTrace();
					System.out.println("\nFile \"" + input_file + "\" can not be closed correctly!");
				}
			}
		}

		try {
			System.out.print("\n...press [Enter] key to exit.");
			System.in.read();
		} catch (IOException e3) {
			// TODO Auto-generated catch block
			//e3.printStackTrace();
			System.out.println("Application is not close correctly!");
		}
	}

}