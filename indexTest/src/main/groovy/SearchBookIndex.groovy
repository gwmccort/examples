import java.nio.file.Paths

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.FSDirectory


class SearchBookIndex {

	private static final INDEX_PATH = 'index'
	private static final SEARCH = 'Connector'

	static main(args) {

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX_PATH)))
		IndexSearcher searcher = new IndexSearcher(reader)
		Analyzer analyzer = new StandardAnalyzer()


		Query query = new QueryParser('name', analyzer).parse(SEARCH)
		TopDocs results = searcher.search(query, 100)

		ScoreDoc[] hits = results.scoreDocs
		println "hits: ${hits.size()}"
		for (sd in hits) {
			//			tesprintln sd
			//			println sd.dump()
			Document doc = searcher.doc(sd.doc)
			println doc
		}

		//		// get input from console & multi-field
		//		println 'Enter query or "exit!" to quit:'
		//		System.in.eachLine() { line ->
		//			if (line == 'exit!') {
		//				reader.close()
		//				System.exit(0)
		//			}
		//			else {
		////				String[] fields = [ARTIST_FIELD, NAME_FIELD, ALBUM_FIELD]
		////				QueryParser parser = new MultiFieldQueryParser(fields, analyzer)
		////				Query query = parser.parse(line)
		////				TopDocs results = searcher.search(query, 100)
		//
		//				ScoreDoc[] hits = results.scoreDocs
		//				println "hits: ${hits.size()}"
		//				for (sd in hits) {
		//					//			tesprintln sd
		//					//			println sd.dump()
		//					Document doc = searcher.doc(sd.doc)
		//					println "artist:${doc.get(ARTIST_FIELD)} name:${doc.get(NAME_FIELD)} album:${doc.get(ALBUM_FIELD)}"
		//				}
		//			}
		//			println 'Enter query or "exit!" to quit:'
		//		}
	}

}
