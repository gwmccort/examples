import static groovy.io.FileType.FILES

import java.nio.file.Path
import java.nio.file.Paths


class Mp3FileTest {

	static main(args) {
		String musicDir = /C:\Users\Glen\Music/
		
		// command line args
		def cli = new CliBuilder(usage: "FileTracksCsvFile [-hm]")
		cli.with {
			h(longOpt: 'help'  , 'usage information'   , required: false)
			m(longOpt: 'musicDir', 'music directory', args: 1, required: false)
		}
		OptionAccessor opt = cli.parse(args)
		if(opt.h) {
			cli.usage()
			System.exit(0)
		}
		if (opt.d) {
			musicDir = opt.m
		}

//		final Path path = Paths.get("C:\\Users\\Glen\\Music")
		
//		path.eachFileRecurse(FILES) { 
//			println it
//			
//		}
		
		FileTrack[] tracks = FileTrack.getMp3Files("C:\\Users\\Glen\\Music")
		for (t in tracks) {
			println t
		}
	}

}
