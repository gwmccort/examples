package trait_model

import groovy.io.FileType

import java.nio.file.Path
import java.nio.file.Paths

//@ToString(includeNames=true)
//@ToString(includeNames=true,includeSuperProperties=true) // doesn't work with traits
class FileTrack implements Track {
	Path path

	static main(args) {
		FileTrack ft = new FileTrack()
		ft.name = 'name'
		ft.artist = 'artist'
		ft.album = 'album'
		ft.path = Paths.get('c:/tmp')

		println ft

		Path p = Paths.get(/C:\Users\Public\Music/)
		List files = getMp3Files(p)
		files.each { println it }
	}

	//	String toString()


	static List getMp3Files(Path path) {
		List files = []
		path.eachFileRecurse(FileType.FILES) {
			if (it.toString() ==~ /.*\.(mp3)$/) {
				files << it
			}
		}
		return files
	}

	public String toString() {
		return "FileTrack[artist:${artist}, name:${name}, album:${album}, path:${path.toString()}]"
	}
}
