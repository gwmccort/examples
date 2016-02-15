/**
 * Create a CSV file of MusicFileTracks
 * 
 * @author Glen
 *
 */
class FileTracksCsvFile {

	static main(args) {
		
		//TODO don't use toURL & create a config class
		def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURL())
		
		FileTrack[] tracks = FileTrack.getMp3Files(config.musicDir)
		println tracks.size()
		for (track in tracks) {
			println track
		}
		
		FileTrack.writeTracksToCSV(tracks)
	}

}
