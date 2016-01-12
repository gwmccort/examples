package indexTest

import groovy.util.logging.Slf4j

import java.nio.file.Paths

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.TextField
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.IndexWriterConfig.OpenMode
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory

@Slf4j
class IndexTest {

	private static final INDEX = 'index'

	static main(args) throws Exception {
		log.info 'main'

		Directory dir = FSDirectory.open(Paths.get(INDEX))
		Analyzer analyzer = new StandardAnalyzer()
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer)

		//		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND)
		iwc.setOpenMode(OpenMode.CREATE)
		IndexWriter writer = new IndexWriter(dir, iwc)
		
		Document d = new Document()
		Field f = new Field('test', 'test', TextField.TYPE_STORED)
		d.add(f)
		writer.addDocument(d)
		
		d = new Document()
		f = new Field('test', 'glen', TextField.TYPE_STORED)
		d.add(f)
		writer.addDocument(d)

		writer.close()

		log.info 'finished'
	}
}
