
import groovy.util.logging.Slf4j

import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.SimpleFileVisitor
import java.nio.file.attribute.BasicFileAttributes

@Slf4j
class WalkFileTree {

	//	static final String DIR_PATH = 'H:/Project_Files/eBooks'
	static final String DIR_PATH = /C:\Users\Glen\Downloads/

	static main(args) {
		println 'Starting ...'
		Path path = Paths.get(DIR_PATH)
		def visitor = new PdfFilesVisitor()

		log.debug 'root dir{}', DIR_PATH

		try {
			Files.walkFileTree(path, visitor)
		}
		catch (Exception e) {
			e.printStackTrace()
		}

		println 'visitor size:' + visitor.pdfFiles.size()
		visitor.pdfFiles.each() { log.info it.toString() }

		//		def pdfs = path.eachFileMatch(~/.*\.pdf/) {
		//			println it
		//		}

		println 'finished!'
	}

}

/**
 * File visitor to collect pdf files.
 *
 * @author gwmccort
 *
 */
@Slf4j
class PdfFilesVisitor extends SimpleFileVisitor<Path> {
	List<Path> pdfFiles = []

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		if (file.toString().endsWith('pdf')) {
			pdfFiles << file
		}
		return FileVisitResult.CONTINUE
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
	throws IOException {
		// ignore access denied
		return FileVisitResult.SKIP_SUBTREE
	}
}
