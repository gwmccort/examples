package test.file

import java.nio.file.Path
import java.nio.file.Paths
import java.util.regex.Pattern

/**
 * @author gwmccort
 * @see <a href="http://mrhaki.blogspot.com/2014/05/groovy-goodness-extra-methods-for-nio.html">Extra Methods for NIO Path</a>
 *<p>
 *<a href="http://docs.groovy-lang.org/latest/html/groovy-jdk/java/nio/file/Path.html">GDK Path</a>
 *
 */
class NioFileWalker {

	static final Path eBooksPath = Paths.get('H:/Project_Files/eBooks')

	static main(args) {

		//		final Path root = Paths.get('.')
		//		//		def paths = root.eachFileMatch(~/.*\.groovy$/) {
		//		//			assert it.toFile().name == 'output.txt'
		//		//		}
		//
		//		//
		//		root.eachFileRecurse() { println it }


		//		eBooksPath.eachFileRecurse() {
		//			println it
		//		}

		def m = ~/.*\.(pdf|txt)$/
		//		def x = eBooksPath.eachFileMatch(m) {
		//			println it
		//			it
		//		}

		Pattern p = ~/.*\.(pdf|txt)$/
//		List files = walkTree(eBooksPath, p)
		List files = walkTree(eBooksPath, ~/.*\.(pdf|txt)$/)
		files.each() {
			println it
		}


	}

	private static walkTree(Path path, Pattern extensionPattern) {
		List files = []
		path.eachFileRecurse() {
			if (it.toString() ==~ extensionPattern) {
				files << it
			}
		}

		return files
	}
}
