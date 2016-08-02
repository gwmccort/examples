package gwm.file;

import gwm.model.Track
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
		
//		def line
//		List<Track> tracks = []
//		while ((line = reader.readNext()) != null) {
////			println line
//			tracks << new Track(albumArtist:line[0], artist:line[1])
//		}
//		
//		tracks.each() {
//			println it
//		}
		
		// test equals
		def t1 = new Track(name:'name1', artist:'artist1', album:'album')
//		def t2 = new Track(name:'name2', artist:'artist1', album:'album')
		def t2
		println t1.equals(t2)
		println t1.hashCode()
		println t2?.hashCode()

	}
}
