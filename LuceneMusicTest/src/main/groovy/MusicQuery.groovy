import java.nio.file.Paths

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.FSDirectory

/**
 * Query Lucene via the command line
 * 
 * @author Glen
 *
 */
class MusicQuery {

	private static final INDEX = 'index'
	private static final ARTIST_FIELD = 'artist'
	private static final NAME_FIELD = 'name'
	private static final ALBUM_FIELD = 'album'

	static main(args) {
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX)))
		IndexSearcher searcher = new IndexSearcher(reader)
		Analyzer analyzer = new StandardAnalyzer()

		// get input from console
		println 'Enter query or "exit!" to quit:'
		System.in.eachLine() { line ->
			if (line == 'exit!') System.exit(0)
			else {
				String[] fields = [ARTIST_FIELD, NAME_FIELD, ALBUM_FIELD]
				QueryParser parser = new MultiFieldQueryParser(fields, analyzer)
				Query query = parser.parse(line)
				TopDocs results = searcher.search(query, 100)

				ScoreDoc[] hits = results.scoreDocs
				println "hits: ${hits.size()}"
				for (sd in hits) {
					//			tesprintln sd
					//			println sd.dump()
					Document doc = searcher.doc(sd.doc)
					println "artist:${doc.get(ARTIST_FIELD)} name:${doc.get(NAME_FIELD)} album:${doc.get(ALBUM_FIELD)}"
				}
			}
			println 'Enter query or "exit!" to quit:'
		}

	}
}
