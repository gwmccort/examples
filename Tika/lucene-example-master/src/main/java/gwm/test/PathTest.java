package gwm.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get("H:\\Project_Files\\eBooks\\Web\\HTML5-Programming-Cookbook.pdf");
		String fileName = path.getFileName().toString();
		System.out.println(fileName);
//		System.out.println(path.getFileName().normalize());
		
		String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
		System.out.println(fileNameWithOutExt);
		
		String fileNameNoJunk = fileNameWithOutExt.replaceAll("[-_]", " ");
		System.out.println(fileNameNoJunk);
	}

}
