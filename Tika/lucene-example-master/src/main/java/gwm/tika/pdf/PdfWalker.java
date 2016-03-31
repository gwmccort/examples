package gwm.tika.pdf;

import java.io.FileInputStream;
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

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Get pdf meta data from tika by walking a directory tree.
 * 
 * @author gwmccort
 *
 */
public class PdfWalker {

//	final static String START_PATH = "H:\\Project_Files\\eBooks";
	final static String START_PATH = "C:\\Users\\Glen\\Downloads\\Torrents\\Completed";
	
	private static final Logger log = LoggerFactory.getLogger(PdfWalker.class);


	public static void main(String[] args) throws Exception {
		PdfWalker pw = new PdfWalker();
		
//		File file = new File("PdfWalker.log");
//		FileWriter fw = new FileWriter(file.getAbsoluteFile());
//		BufferedWriter log = new BufferedWriter(fw);
//		try {
//		log.write("starting\n");
//		log.write("starting\n");
//		log.write("starting\n");
//		log.close();
//		System.out.println("PdfWalker.main()");
//		System.exit(0);

		for (Path p : pw.walkWithVisitor(Paths.get(START_PATH))) {
			log.info("pdf path:{}",p);

			BodyContentHandler handler = new BodyContentHandler(-1); // ignore
																		// limit
			Metadata metadata = new Metadata();

			FileInputStream inputstream = new FileInputStream(p.toFile());
			ParseContext pcontext = new ParseContext();
			PDFParser pdfparser = new PDFParser();
			try {
				pdfparser.parse(inputstream, handler, metadata, pcontext);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				inputstream.close();
			}

			// getting the content of the document
			// System.out.println("Contents of the PDF :" + handler.toString());

			System.out.println("title:" + metadata.get("title"));
			if (null == metadata.get("title") || metadata.get("title").equals("") || metadata.get("title").equals("Java: Graphical User Interfaces")) {
//				System.out.println("-------- title blank or junk");
//				System.out.println("title from file name:" + getTitleFromFileName(p));
				log.info("-------- title blank or junk");
				log.info("title from file name:{}", getTitleFromFileName(p));
			} else {
//				System.out.println("not blank or null title:" + metadata.get("title"));
				log.info("not blank or null title:{}", metadata.get("title"));
			}
			// getting metadata of the document
			// System.out.println("---------Metadata of the PDF:");
			// String[] metadataNames = metadata.names();
			// for (String name : metadataNames) {
			// System.out.println(name + " : " + metadata.get(name));
			// }

		}
//		}
//		finally {
//			log.close();
//		}

	}
	
	/**
	 * Get title from file name
	 * @param path of file
	 * @return title
	 */
	public static String getTitleFromFileName(Path path) {
		String results = "";
		String fileName = path.getFileName().toString();
		String fileNameWithOutExt = fileName.replaceFirst("[.][^.]+$", "");
		results = fileNameWithOutExt.replaceAll("[-_\\.]", " ");
		return results;
	}

 	public List<Path> walkWithVisitor(Path path) {
		PdfFileVisitor2 pdfVisitor = new PdfFileVisitor2();
		try {
			Files.walkFileTree(path, pdfVisitor);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pdfVisitor.getPdfFiles();
	}

}

class PdfFileVisitor2 extends SimpleFileVisitor<Path> {
	List<Path> pdfFiles = new ArrayList<>();

	public List<Path> getPdfFiles() {
		return pdfFiles;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**.pdf");

		if (matcher.matches(file)) {
			pdfFiles.add(file);
		}
		return FileVisitResult.CONTINUE;
	}
}
