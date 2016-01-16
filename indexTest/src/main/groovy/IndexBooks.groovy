
import groovy.util.logging.Slf4j

import java.nio.file.Paths

import org.apache.commons.io.FileUtils
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

import au.com.bytecode.opencsv.CSVWriter

/**
 * Index Books into a Lucene index.
 *
 * @author gwmccort
 *
 */
@Slf4j
class IndexBooks {

	private static final BOOKS_PATH = /C:\Users\Glen\Documents\Books/
//	private static final BOOKS_PATH = 'H:/Project_Files/eBooks'
	private static final INDEX_PATH = 'index'
	private static final CSV_FILE = 'eBooks.csv'
	private static final String[] EXTENSIONS = ['pdf', 'chm']

	static main(args) throws Exception {
		log.info 'main'

		// get list of files
		Collection<File> files = FileUtils.listFiles(new File(BOOKS_PATH), EXTENSIONS, true)

		// open index
		Directory dir = FSDirectory.open(Paths.get(INDEX_PATH))
		Analyzer analyzer = new StandardAnalyzer() //TODO: custom analyzer
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer)

		//		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND)
		iwc.setOpenMode(OpenMode.CREATE)
		IndexWriter writer = new IndexWriter(dir, iwc)

		// index files
		CSVWriter csvWriter = new CSVWriter(new FileWriter(CSV_FILE))
		files.each { file ->
			Document d = new Document()
			Field f = new Field('name', file.name, TextField.TYPE_STORED)
			d.add(f)
			writer.addDocument(d)

			csvWriter.writeNext([file.name, file.path] as String[])
		}

		writer.close()
		csvWriter.close()

		log.info 'finished'
	}
}
