import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.io.filefilter.AgeFileFilter;

/** 
 * from: http://www.avajava.com/tutorials/lessons/how-do-i-filter-files-based-on-their-last-modified-dates.html
 */

public class AgeFileFilterTest {

	public static void main(String[] args) throws IOException {

		File directory = new File("c:\\tmp");

		GregorianCalendar cal = new GregorianCalendar();
		cal.set(2014, 10, 15, 0, 0, 0); // Nov 15th, 2014
		Date cutoffDate = cal.getTime();

		System.out.println("All Files");
		displayFiles(directory, null);

		System.out.println("\nBefore " + cutoffDate);
		displayFiles(directory, new AgeFileFilter(cutoffDate));

		System.out.println("\nAfter " + cutoffDate);
		displayFiles(directory, new AgeFileFilter(cutoffDate, false));

	}

	public static void displayFiles(File directory, FileFilter fileFilter) {
		File[] files = directory.listFiles(fileFilter);
		for (File file : files) {
			Date lastMod = new Date(file.lastModified());
			System.out.println("File: " + file.getName() + ", Date: " + lastMod + "");
		}
	}

}