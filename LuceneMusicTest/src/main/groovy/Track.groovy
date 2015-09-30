import groovy.transform.ToString
import groovy.transform.TupleConstructor

import java.nio.file.Paths
import java.util.logging.Handler

import org.apache.lucene.analysis.Analyzer
import org.apache.lucene.analysis.standard.StandardAnalyzer
import org.apache.lucene.document.Document
import org.apache.lucene.document.Field
import org.apache.lucene.document.TextField
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.IndexWriter
import org.apache.lucene.index.IndexWriterConfig
import org.apache.lucene.index.IndexWriterConfig.OpenMode
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser
import org.apache.lucene.queryparser.classic.QueryParser
import org.apache.lucene.search.IndexSearcher
import org.apache.lucene.search.Query
import org.apache.lucene.search.ScoreDoc
import org.apache.lucene.search.TopDocs
import org.apache.lucene.store.Directory
import org.apache.lucene.store.FSDirectory
import org.jaudiotagger.audio.mp3.MP3File
import org.jaudiotagger.tag.FieldKey
import org.jaudiotagger.tag.Tag

@TupleConstructor(force=true)
@ToString(includeNames=true)
class Track {
	String artist
	String name
	String album

	private static final INDEX = 'index'
	private static final ARTIST_FIELD = 'artist'
	private static final NAME_FIELD = 'name'
	private static final ALBUM_FIELD = 'album'

	/**
	 * Create Track from music file tags
	 * @param tag
	 */
	Track(Tag tag) {
		 artist = tag.getFirst(FieldKey.ARTIST)
		 name=tag.getFirst(FieldKey.TITLE)
		 album=tag.getFirst(FieldKey.ALBUM)
	}

	static main(args) {
				indexTest()
		//		searchTest('test')
		//		multiSearchTest('test')
//		getMp3Files()
	}

	static indexTest() {
		println '>>> indexing tracks...'

		Directory dir = FSDirectory.open(Paths.get(INDEX))
		Analyzer analyzer = new StandardAnalyzer()
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer)

		//		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND)
		iwc.setOpenMode(OpenMode.CREATE)
		IndexWriter writer = new IndexWriter(dir, iwc)

		// add track to index
		def tracks = getTracks()
		for (track in tracks) {
			Document doc = new Document()
			Field artist = new Field(ARTIST_FIELD, track.artist, TextField.TYPE_STORED)
			Field name = new Field(NAME_FIELD, track.name, TextField.TYPE_STORED)
			Field album = new Field(ALBUM_FIELD, track.album, TextField.TYPE_STORED)
			doc.add(artist)
			doc.add(name)
			doc.add(album)
			writer.addDocument(doc)
		}

		writer.close()
	}

	static searchTest(String queryString) {
		println '>>> searching tracks...'

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX)))
		IndexSearcher searcher = new IndexSearcher(reader)
		Analyzer analyzer = new StandardAnalyzer()

		QueryParser parser = new QueryParser(NAME_FIELD, analyzer)
		Query query = parser.parse(queryString)
		//		println query
		//		println query.class

		TopDocs results = searcher.search(query, 100)

		ScoreDoc[] hits = results.scoreDocs
		println hits.size()
		for (sd in hits) {
			//			println sd
			//			println sd.dump()
			Document doc = searcher.doc(sd.doc)
			println "artist:${doc.get(ARTIST_FIELD)} name:${doc.get(NAME_FIELD)} album:${doc.get(ALBUM_FIELD)}"
		}
	}

	static multiSearchTest(String queryString) {
		println '>>> multi field search ...'

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX)))
		IndexSearcher searcher = new IndexSearcher(reader)
		Analyzer analyzer = new StandardAnalyzer()

		String[] fields = [ARTIST_FIELD, NAME_FIELD, ALBUM_FIELD]
		QueryParser parser = new MultiFieldQueryParser(fields, analyzer)
		Query query = parser.parse(queryString)
		//		println query
		//		println query.class

		TopDocs results = searcher.search(query, 100)

		ScoreDoc[] hits = results.scoreDocs
		println hits.size()
		for (sd in hits) {
			//			println sd
			//			println sd.dump()
			Document doc = searcher.doc(sd.doc)
			println "artist:${doc.get(ARTIST_FIELD)} name:${doc.get(NAME_FIELD)} album:${doc.get(ALBUM_FIELD)}"
		}

	}

	static Track[] getTracks() {
		def tracks = []
		tracks << new Track(artist:'Yonter Mountain String Band', name:'40 Miles from Denver', album:'Elevation test')
		tracks << new Track(artist:'Grateful Dead', name:'Trucking test', album:'American Beauty')
		tracks << new Track(artist:'Test artist', name:'test track name', album:'test album')
		tracks
	}

	/**
	 * Example of using jaudiotagger to get mp3 tags
	 * @return
	 */
	static getMp3Files() {
		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		new File(/C:\Users\Public\Music/).eachDirRecurse { dir ->
			dir.eachFileMatch(~/.*.mp3/) { file ->
//				println file
				try {
					MP3File mf = new MP3File(file)
					Tag tag = mf.getTag()
//					Track t = new Track(artist:tag.getFirst(FieldKey.ARTIST), name:tag.getFirst(FieldKey.TITLE), album:tag.getFirst(FieldKey.ALBUM))
					Track t = new Track(tag)
					println t
				}
				catch (Exception e) {
					e.printStackTrace()
				}

			}
		}
	}

}


