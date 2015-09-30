import org.apache.commons.io.comparator.NameFileComparator;
import java.io.File;
import java.util.Arrays;

public class NameFileComparatorExample2 {

	public static void main(String [] args) {

		System.out.println("### Input files ###");
		File dir = new File("X:\\testdir\\");
		File [] files = dir.listFiles();
		printArrayContents(files);

		System.out.println("### Array sorted ###");
		Arrays.sort(files, NameFileComparator.NAME_INSENSITIVE_REVERSE);
		printArrayContents(files);
	}

	private static void printArrayContents(File [] files) {

		for (File file : files) {

			System.out.println(file.getName());
		}

		System.out.println("");
	}
}
