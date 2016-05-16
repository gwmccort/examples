package gwm.test

//import static groovy.io.FileType

import java.nio.file.Path
import java.nio.file.Paths

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.Parser
import org.apache.tika.parser.mp3.Mp3Parser
import org.xml.sax.ContentHandler
import org.xml.sax.helpers.DefaultHandler


class Mp3FileSearch {

	static main(args) {
		String pathName = 'C:/Users/Glen/Music'
		Path path = Paths.get(pathName)

		path.eachFileRecurse(groovy.io.FileType.FILES) { path2 ->
			if (path2.toString() ==~ /.*\.(mp3)$/) {

//				InputStream input = new FileInputStream(new File(file));
				InputStream input = new FileInputStream(path2.toFile());
				ContentHandler handler = new DefaultHandler();
				Metadata metadata = new Metadata();
				Parser parser = new Mp3Parser();
				ParseContext parseCtx = new ParseContext();
				parser.parse(input, handler, metadata, parseCtx);
				input.close();

				String[] metadataNames = metadata.names();

				for (String name : metadataNames) {
					println(name + ": " + metadata.get(name));
				}

				// Retrieve the necessary info from metadata
				// Names - title, xmpDM:artist etc. - mentioned below may differ
				// based
				// on the standard used for processing and storing standardized
				// and/or
				// proprietary information relating to the contents of a file.

				println("Title: " + metadata.get("title"));
				println("Artists: " + metadata.get("xmpDM:artist"));
				println("Genre: " + metadata.get("xmpDM:genre"));
			}
		}
	}
}
