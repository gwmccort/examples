/**
 * Create a CSV file of MusicFileTracks
 *
 * @author Glen
 *
 */
class FileTracksCsvFile {

	static main(args) {


//		println ClassLoader.getSystemResource('Config.groovy').class

//		println System.getProperty('java.class.path')
//		System.exit(0)

		//TODO don't use toURL & create a config class
//works	in eclipse & idea
		def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())

		// works in gradle, but not ide
//		def config = new ConfigSlurper().parse(ClassLoader.getSystemResource('Config.groovy'))
//		def config = new ConfigSlurper().parse(this.getResource('Config.groovy'))
//		ConfigObject config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())

		//http://stackoverflow.com/questions/6127041/can-i-use-configslurper-to-reference-a-config-file-in-the-classpath
//		Class scriptClass = getClass().classLoader.loadClass('Config')
//		println scriptClass
//		ConfigObject config = new ConfigSlurper().parse(scriptClass)

//		Class scriptClass = this.class.classLoader.loadClass('Config', true, false )?.newInstance()
//		ConfigObject config = new ConfigSlurper().parse(scriptClass)

//		println this.class.getClassLoader()

//		System.exit(0)

		FileTrack[] tracks = FileTrack.getMp3Files(config.musicDir)
		println tracks.size()
		for (track in tracks) {
			println track
		}

		FileTrack.writeTracksToCSV(tracks)
	}

}
