import groovy.util.logging.Slf4j

import java.nio.file.Paths

import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.store.FSDirectory

@Slf4j
class PrintBookIndex {

	private static final INDEX_PATH = 'index'

	static main(args) {

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX_PATH)))
		println reader.numDocs()

		for (i in 0..reader.numDocs()-1) {
			Document d = reader.document(i)
			println "i: $i d: $d"
		}

		reader.close()
	}
}
