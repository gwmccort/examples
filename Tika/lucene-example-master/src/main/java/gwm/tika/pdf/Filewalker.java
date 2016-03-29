package gwm.tika.pdf;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class Filewalker {

	public void walk(String path) {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				System.out.println("File:" + f.getAbsoluteFile());
			}
		}
	}

	public static void main(String[] args) {
		Filewalker fw = new Filewalker();
		// fw.walk("C:\\Users\\gwmccort\\Downloads" );
		fw.walkWithVisitor("C:\\Users\\gwmccort\\Downloads");
	}

	public void walkWithVisitor(String pathName) {
		Path path = Paths.get(pathName);
		PdfFileVisitor pdfVisitor = new PdfFileVisitor();
		try {
			Files.walkFileTree(path, pdfVisitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		for (Path p:pdfVisitor.getPdfFiles()) {
			System.out.println("pdf path:" + p);
		}
	}

}

class PdfFileVisitor extends SimpleFileVisitor<Path> {
	List<Path> pdfFiles = new ArrayList<>();

	public List<Path> getPdfFiles() {
		return pdfFiles;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.pdf");
		
		if (matcher.matches(file)) {
			System.out.println("file matcher:" + file);
		}
//		if (file.toString().toLowerCase().endsWith(".pdf")) {
//			System.out.println("file endsWith:" + file);
//			System.out.println("file:" + file + " matches:" + matcher.matches(file));
//		}
		return FileVisitResult.CONTINUE;
		// return super.visitFile(file, attrs);
	}

}