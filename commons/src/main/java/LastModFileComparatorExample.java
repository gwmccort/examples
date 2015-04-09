import org.apache.commons.io.comparator.LastModifiedFileComparator;
import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * from: http://examples.javacodegeeks.com/core-java/apache/commons/io-commons/comparator-io-commons/lastmodifiedfilecomparator/org-apache-commons-io-comparator-lastmodifiedfilecomparator-example/
 */

public class LastModFileComparatorExample {

    public static void main(String [] args) {

        LastModifiedFileComparator comparator = new LastModifiedFileComparator();

        System.out.println("### Input files ###");
        File dir = new File("c:\\tmp");
        File [] files = dir.listFiles();
        printArrayContents(files);

        System.out.println("### Array sorted ###");
        files = comparator.sort(files);
        printArrayContents(files);
    }

    private static void printArrayContents(File [] files) {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy MMM dd HH:mm");

        for (File file : files) {

            Date date = new Date(file.lastModified());
            System.out.println(formatter.format(date) + "    " + file.getName());
        }

        System.out.println("");
    }
}