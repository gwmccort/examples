import org.apache.commons.io.comparator.NameFileComparator;
import java.io.File;

public class NameFileComparatorExample1 {

	public static void main(String [] args) {

		NameFileComparator comparator = new NameFileComparator();

		System.out.println("### Input files ###");
		File dir = new File("X:\\testdir\\");
		File [] files = dir.listFiles();
		printArrayContents(files);

		System.out.println("### Array sorted ###");
		files = comparator.sort(files);
		printArrayContents(files);
	}

	private static void printArrayContents(File [] files) {

		for (File file : files) {

			System.out.println(file.getName());
		}

		System.out.println("");
	}
}
