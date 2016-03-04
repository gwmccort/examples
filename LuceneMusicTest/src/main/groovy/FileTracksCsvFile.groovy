/**
 * Create a CSV file of MusicFileTracks
 *
 * @author Glen
 *
 */
class FileTracksCsvFile {

	static main(args) {

		// set default configuration
		def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())
		def env = config.home
		if (InetAddress.localHost.hostName=='CRP22627'){
			env = config.work
		}

		// command line args
		def cli = new CliBuilder(usage: "FileTracksCsvFile [-he]")
		cli.h(longOpt: 'help'  , 'usage information'   , required: false)
		cli.e(longOpt: 'env', 'config environment[home|work]', required: false)
		OptionAccessor opt = cli.parse(args)
		//		if(opt.h || opt.arguments().isEmpty()) {
		if(opt.h) {
			cli.usage()
			System.exit(0)
		}
		if(opt.e){
			println "opt e:" + opt.e
			env = config.opt.e
		}

		println env.musicDir

		//		println ClassLoader.getSystemResource('Config.groovy').class

		//		println System.getProperty('java.class.path')
		//		System.exit(0)



		//TODO don't use toURL & create a config class
		//works	in eclipse & idea
		//		def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())

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
		FileTrack[] tracks = FileTrack.getMp3Files(env.musicDir)

		println tracks.size()
		for (track in tracks) {
			println track
		}

		FileTrack.writeTracksToCSV(tracks)
	}

}
