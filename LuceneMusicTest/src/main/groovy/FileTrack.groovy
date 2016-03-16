import groovy.transform.ToString

import java.util.logging.Handler
import java.util.regex.Pattern

import org.jaudiotagger.audio.mp3.MP3File
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag

import au.com.bytecode.opencsv.CSVWriter

@ToString(includeNames=true, includeSuper=true)
class FileTrack extends Track {
	String filePath


	/**
	 * Create Track from music file tags
	 * @param tag
	 */
	FileTrack(Tag tag, String fileName) {
		artist = tag.getFirst(FieldKey.ARTIST)
		name=tag.getFirst(FieldKey.TITLE)
		album=tag.getFirst(FieldKey.ALBUM)
		filePath = fileName
	}

	/**
	 * Example of using jaudiotagger to get mp3 tags
	 * @return
	 */
	static FileTrack[] getMp3Files(String pathRoot) {
		println "getMp3Files"
		def results = []

//		Pattern fileRegExp = ~/.*.(mp3|flac)/
		Pattern fileRegExp = ~/.*.(mp3)/

		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		///^(apple|banana)$/
		//		new File(/C:\Users\Public\Music/).eachDirRecurse { dir ->
		//			new File(/C:\Users\Glen\Music/).eachDirRecurse { dir ->
		println "pathRoot: $pathRoot"
		//TODO: doesn't work if no subdirs!!!
		new File(pathRoot).eachDirRecurse { dir ->
			println "dir: $dir"
			dir.eachFileMatch(fileRegExp) { file ->
				println "file: $file"
				try {
					//					MP3File mf = new MP3File(file)
					MP3File mf = new MP3File(file, MP3File.LOAD_ALL, true)
					Tag tag = mf.getTag()
					//					Track t = new Track(artist:tag.getFirst(FieldKey.ARTIST), name:tag.getFirst(FieldKey.TITLE), album:tag.getFirst(FieldKey.ALBUM))
					FileTrack t = new FileTrack(tag, file.path)
					results << t
				}
				catch (Exception e) {
					//					e.printStackTrace()
					println e
				}
			}
		}
		results
	}

	/**
	 * Convert track to array of strings
	 * @return
	 */
	String[] toStringArray() {
		[artist, name, album, filePath] as String[]
	}

	/**
	 * Write tacks to a CSV file
	 * @param tracks
	 * @return
	 */
	static writeTracksToCSV(FileTrack[] tracks) {
		CSVWriter writer = new CSVWriter(new FileWriter('FileTrack.csv'))
		tracks.each { t ->
			writer.writeNext(t.toStringArray())
		}
		writer.close()
	}

}
