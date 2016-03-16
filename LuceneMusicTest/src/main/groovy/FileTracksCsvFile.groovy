import groovy.util.logging.Slf4j

/**
 * Create a CSV file of MusicFileTracks
 *
 * @author Glen
 *
 */
@Slf4j
class FileTracksCsvFile {

	static main(args) {
		def musicDir = ''

		// set default configuration
		def config = new ConfigSlurper().parse(new File("src/main/resources/Config.groovy").toURI().toURL())
		def env = config.home
		if (InetAddress.localHost.hostName=='CRP22627'){
			println '-----------work env'
			env = config.work
		}

		// command line args
		def cli = new CliBuilder(usage: "FileTracksCsvFile [-hem]")
		cli.with {
			h(longOpt: 'help'  , 'usage information'   , required: false)
			e(longOpt: 'env', 'config environment[home|work]', required: false)
			m(longOpt: 'musicDir', 'music directory', args: 1, required: false)
		}
		OptionAccessor opt = cli.parse(args)
		//		if(opt.h || opt.arguments().isEmpty()) {
		if(opt.h) {
			cli.usage()
			System.exit(0)
		}
		if(opt.e){
			env = config.opt.e
		}
		if(opt.m){
            musicDir = opt.m
		} else {
			musicDir = env.musicDir
		}
		println "musicDir: $musicDir"

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
		FileTrack[] tracks = FileTrack.getMp3Files(musicDir)
		println "musicDir: ${env.musicDir}"

    if(log.isDebugEnabled()) {
        log.debug("tracks size:{}", tracks.size())
        for (track in tracks) {
            log.debug track.toString()
        }
    }

		// println tracks.size()
		// for (track in tracks) {
		// 	println track
		// }

		FileTrack.writeTracksToCSV(tracks)
	}

}
