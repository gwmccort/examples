package gwm.file;

import groovy.util.logging.Slf4j
import gwm.model.Track

import java.nio.file.InvalidPathException
import java.nio.file.Paths

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVRecord

/**
 * Read csv file created by Mp3File & do set operations
 * 
 * @author gwmccort
 *
 */
@Slf4j()
public class ReadMusicFileCSV {

	public static void main(String[] args) {
		log.info 'starting...'

		def input = /H:\Project_Files\github\Mp3File\bitrate.csv/
		//		def input = /C:\Users\Glen\Src\github\music\Mp3File\bitrate.csv/

		// read pogo plug csv
		log.info "pogo orig lines: {}", new File(input).readLines().size()
		Set<Track> tracksPogo = getCsvTracks(input)
		log.info 'tracksPogo set size: {}', tracksPogo.size()

		// read nas csv
		input = /H:\Project_Files\github\Mp3File\bitrate-nas.csv/
		//		input = /C:\Users\Glen\Src\github\music\Mp3File\bitrate-nas.csv/
		log.info "nas orig lines: {}", new File(input).readLines().size()
		Set<Track> tracksNas = getCsvTracks(input)
		log.info 'tracksNas set size: {}', tracksNas.size()

		// tracks in pogo but not in nas
		Set<Track> diff = new HashSet(tracksPogo)
		diff.removeAll(tracksNas)
		diff.each() {  log.info 'only in pogo: {}', it }

		log.info 'end'
	}

	/**
	 * Get set of tracks from csv file
	 * <p>Columns
	 * <pre>
	 * 0	album artist
	 * 1	artist
	 * 2	album
	 * 3	name
	 * 4	bitrate
	 * 5	file path
	 * </pre>
	 * @param fileName
	 * @return set of tracks
	 */
	static Set<Track> getCsvTracks(String fileName) {
		Set<Track> results = [] as Set
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(new FileReader(fileName))
		for (CSVRecord record : records) {
			try {
				results << new Track(albumArtist:record[0], artist:record[1], album:record[2], name:record[3], path:Paths.get(record[5]))
			}
			catch (InvalidPathException ipe) {
				log.warn ipe.message
			}
		}
		return results
	}
}
