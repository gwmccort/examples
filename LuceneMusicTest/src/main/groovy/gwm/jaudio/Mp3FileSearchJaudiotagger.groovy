package gwm.jaudio

import static groovy.io.FileType.FILES

import java.nio.file.Path
import java.nio.file.Paths
import java.util.logging.Handler

import org.jaudiotagger.audio.mp3.MP3File
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag

class Mp3FileSearchJaudiotagger {

	static main(args) {
		String pathName = 'C:/Users/Glen/Music'
//		String pathName = 'C:\\Users\\Public\\Music\\Sample Music'

		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		Paths.get(pathName).eachFileRecurse(FILES) { path ->
			if (path.toString() ==~ /.*\.(mp3)$/) {
				MP3File mf = new MP3File(path.toFile(), MP3File.LOAD_ALL, true)
				Tag tag = mf.getTag()

				//println mf

				println "--------- $path ---------"
				println "Title: ${tag.getFirst(FieldKey.TITLE)}"
				println "Artist: ${tag.getFirst(FieldKey.ARTIST)}"
				println "Album: ${tag.getFirst(FieldKey.ALBUM)}"
				println "Track: ${tag.getFirst(FieldKey.TRACK)}"

			}
		}
	}
}
