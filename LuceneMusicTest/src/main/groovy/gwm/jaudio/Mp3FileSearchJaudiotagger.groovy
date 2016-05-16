package gwm.jaudio

import static groovy.io.FileType.FILES

import java.nio.file.Path
import java.nio.file.Paths

class Mp3FileSearchJaudiotagger {

	static main(args) {
		String pathName = 'C:/Users/Glen/Music'
		Path path = Paths.get(pathName)

		path.eachFileRecurse(FILES) { path2 ->
			if (path2.toString() ==~ /.*\.(mp3)$/) {
			}
		}
	}
}
