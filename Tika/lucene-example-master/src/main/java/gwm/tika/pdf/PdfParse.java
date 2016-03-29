package gwm.tika.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

/**
 * @author Glen
 * @see <a href=
 *      http://www.tutorialspoint.com/tika/tika_extracting_pdf.htm>Extracting
 *      pdf Files</a>
 */
public class PdfParse {

	public static void main(final String[] args) throws IOException, TikaException, SAXException {

		// BodyContentHandler handler = new BodyContentHandler();
		// http://stackoverflow.com/questions/31079433/how-to-read-large-files-using-tika
		BodyContentHandler handler = new BodyContentHandler(-1); // ignore limit

		Metadata metadata = new Metadata();

		// FileInputStream inputstream = new FileInputStream(new
		// File("documents/TestPdf.pdf"));
//		FileInputStream inputstream = new FileInputStream(
//				new File("C:\\Users\\gwmccort\\My Local Data\\eBooks\\Build\\Gradle_Dependency_Management.pdf"));
		FileInputStream inputstream = new FileInputStream(
				new File("C:\\Users\\gwmccort\\My Local Data\\eBooks\\Build\\Building and Testing with Gradle.pdf"));

		ParseContext pcontext = new ParseContext();

		// parsing the document using PDF parser
		PDFParser pdfparser = new PDFParser();
		pdfparser.parse(inputstream, handler, metadata, pcontext);

		// getting the content of the document
//		System.out.println("Contents of the PDF :" + handler.toString());

		// getting metadata of the document
		System.out.println("Metadata of the PDF:");
		String[] metadataNames = metadata.names();

		for (String name : metadataNames) {
			System.out.println(name + " : " + metadata.get(name));
		}
	}
}