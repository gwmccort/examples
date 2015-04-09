import org.apache.commons.io.comparator.CompositeFileComparator;
import org.apache.commons.io.comparator.ExtensionFileComparator;
import org.apache.commons.io.comparator.SizeFileComparator;
import org.apache.commons.io.FilenameUtils;
import java.io.File;

/**
 * from: http://examples.javacodegeeks.com/core-java/apache/commons/io-commons/comparator-io-commons/compositefilecomparator/org-apache-commons-io-comparator-compositefilecomparator-example/
 */

public class CompositeFileComparatorExample {

    public static void main(String [] args) {

        CompositeFileComparator comparator = new CompositeFileComparator(
ExtensionFileComparator.EXTENSION_COMPARATOR, SizeFileComparator.SIZE_COMPARATOR);

        System.out.println("### Input files ###");
        File dir = new File("c:\\tmp");
        File [] files = dir.listFiles();
        printArrayContents(files);
        System.out.println("");

        System.out.println("### Array sorted (by extension and size) ###");
        files = comparator.sort(files);
        printArrayContents(files);
    }

    private static void printArrayContents(File [] files) {

        for (File file : files) {
		
            String fileExtn = FilenameUtils.getExtension(file.getName());
            System.out.println(file.getName());
            System.out.println("   " + fileExtn  + "     " + file.length());
        }
    }
}