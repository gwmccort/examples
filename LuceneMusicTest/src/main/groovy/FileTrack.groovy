import static groovy.io.FileType.FILES
import groovy.transform.ToString

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.attribute.BasicFileAttributes
import java.nio.file.attribute.FileTime
import java.util.logging.Handler
import java.util.regex.Pattern

import org.jaudiotagger.audio.mp3.MP3File
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag

import au.com.bytecode.opencsv.CSVWriter

/**
 * Track from an MP3 file
 * @see Track
 * @author gwmccort
 *
 */
@ToString(includeNames=true, includeSuper=true)
class FileTrack extends OldTrack {
	/** path of track */
	String filePath
	long size
	FileTime lastModified

	/**
	 * Create Track from music file tags
	 * @param tag
	 */
	FileTrack(Tag tag, String fileName) {
		artist = tag.getFirst(FieldKey.ARTIST)
		name=tag.getFirst(FieldKey.TITLE)
		album=tag.getFirst(FieldKey.ALBUM)
		filePath = fileName
		
		// get path attributes
		Path path = Paths.get(filePath) //TODO should get a path not string
		BasicFileAttributes bfa  = Files.readAttributes(path, BasicFileAttributes.class)
		size = bfa.size()
		lastModified  = bfa.lastModifiedTime()
	}

	/**
	 * Example of using jaudiotagger to get mp3 tags
	 * @return list of tracks
	 */
	static FileTrack[] getMp3Files(String pathName) {
		def results = []
		Path path = Paths.get(pathName)
		
		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		path.eachFileRecurse(FILES) { file ->
			if (file.toString() ==~ /.*\.(mp3)$/) {
				try {
					//					MP3File mf = new MP3File(file)
					MP3File mf = new MP3File(file.toFile(), MP3File.LOAD_ALL, true)
					Tag tag = mf.getTag()
					//					Track t = new Track(artist:tag.getFirst(FieldKey.ARTIST), name:tag.getFirst(FieldKey.TITLE), album:tag.getFirst(FieldKey.ALBUM))
					FileTrack track = new FileTrack(tag, file.toString())
					results << track
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
	 * Example of using jaudiotagger to get mp3 tags
	 * @return list of tracks
	 */
	static FileTrack[] getMp3Files_new(String pathRoot) {
		def results = []

		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		//		new File(/C:\Users\Public\Music/).eachDirRecurse { dir ->
		//			new File(/C:\Users\Glen\Music/).eachDirRecurse { dir ->
		println "pathRoot: $pathRoot"
		new File(pathRoot).eachDirRecurse { dir ->
			//			println "dir: $dir"
			dir.eachFileMatch(~/.*.mp3/) { file ->
				//				println "file: $file"
				try {
					//					MP3File mf = new MP3File(file)
					MP3File mf = new MP3File(file, MP3File.LOAD_ALL, true)
					Tag tag = mf.getTag()
					//					Track t = new Track(artist:tag.getFirst(FieldKey.ARTIST), name:tag.getFirst(FieldKey.TITLE), album:tag.getFirst(FieldKey.ALBUM))
					FileTrack t = new FileTrack(tag, file.toString())
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
	 * Example of using jaudiotagger to get mp3 tags
	 * @return
	 */
	static FileTrack[] getMp3Files_old(String pathRoot) {
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
			//			println "dir: $dir"
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
		[artist, name, album, filePath, size, lastModified] as String[]
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
