package gwm.file;

import gwm.model.Track

import org.apache.commons.lang.time.StopWatch

import au.com.bytecode.opencsv.CSVReader

/**
 * Read csv file created by Mp3File
 * 
 * @author gwmccort
 *
 */
public class ReadMusicFileCSV {

	public static void main(String[] args) {
		def input = /H:\Project_Files\github\Mp3File\bitrate.csv/
		def reader = new CSVReader(new FileReader(input))

		def line
		Set<Track> tracksPogo = [] as Set
		while ((line = reader.readNext()) != null) {
			tracksPogo << new Track(albumArtist:line[0], artist:line[1], album:line[2], name:line[3] )
		}

		input = /H:\Project_Files\github\Mp3File\bitrate-nas.csv/
		Set<Track> tracksNas = [] as Set
		while ((line = reader.readNext()) != null) {
			tracksNas << new Track(albumArtist:line[0], artist:line[1], album:line[2], name:line[3] )
		}

		def stopWatch = new StopWatch()
		stopWatch.start()

		//		Set<Track> diff = new TreeSet(tracksPogo)
		Set<Track> diff = new HashSet(tracksPogo)
		diff.removeAll(tracksNas)
		//		diff.each() { println it }

		stopWatch.stop()
		println "${diff.size()} $stopWatch"
	}
}
