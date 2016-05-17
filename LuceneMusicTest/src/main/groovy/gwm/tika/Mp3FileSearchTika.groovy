package gwm.tika

import static groovy.io.FileType.FILES

import java.nio.file.Path
import java.nio.file.Paths

import org.apache.tika.metadata.Metadata
import org.apache.tika.parser.ParseContext
import org.apache.tika.parser.Parser
import org.apache.tika.parser.mp3.Mp3Parser
import org.xml.sax.ContentHandler
import org.xml.sax.helpers.DefaultHandler

class Mp3FileSearchTika {

	static main(args) {
		String pathName = 'C:/Users/Glen/Music'
		//		String pathName = 'C:\\Users\\Public\\Music\\Sample Music'

		Paths.get(pathName).eachFileRecurse(FILES) { path ->
			if (path.toString() ==~ /.*\.(mp3)$/) {

				ContentHandler handler = new DefaultHandler();
				Parser parser = new Mp3Parser();
				ParseContext parseCtx = new ParseContext();
				path.withInputStream { stream ->
					//					ContentHandler handler = new DefaultHandler();
					Metadata metadata = new Metadata();
					//					Parser parser = new Mp3Parser();
					//					ParseContext parseCtx = new ParseContext();
					parser.parse(stream, handler, metadata, parseCtx);

					// print all metadata
					//					String[] metadataNames = metadata.names();
					//					for (String name : metadataNames) {
					//						println(name + ": " + metadata.get(name));
					//					}

					// Retrieve the necessary info from metadata
					// Names - title, xmpDM:artist etc. - mentioned below may differ
					// based
					// on the standard used for processing and storing standardized
					// and/or
					// proprietary information relating to the contents of a file.

					println "-------- $path --------"
					println("Title: " + metadata.get("title"));
					println("Artists: " + metadata.get("xmpDM:artist"));
					println("Track: " + metadata.get("xmpDM:trackNumber"));
					println("Genre: " + metadata.get("xmpDM:genre"));
				}
			}
		}
	}
}
