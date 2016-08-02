package gwm.model

import static groovy.io.FileType.FILES
import groovy.json.JsonBuilder
import groovy.transform.InheritConstructors
import groovy.transform.ToString

import java.nio.file.Path
import java.nio.file.Paths
import java.util.logging.Handler

import org.apache.commons.lang.builder.EqualsBuilder
import org.apache.commons.lang.builder.HashCodeBuilder
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

/**
 * Track model
 * <p>
 * <b>TODO</b>:
 * <ol>
 * <li>is there a difference between itunes & mp3</li>
 * </ol>
 *
 * @author gwmccort
 */
@InheritConstructors
@ToString(includeNames=true, includePackage=false)
class Track {
	String artist
	String albumArtist
	String track
	String name
	String album
	Path path

	private static final LUCENE_INDEX = 'index'
	private static final ARTIST_FIELD = 'artist'
	private static final NAME_FIELD = 'name'
	private static final ALBUM_FIELD = 'album'

	//	enum FIELD {
	//		artist,
	//		name,
	//		album
	//	}

	/**
	 * Create a track from music file tag
	 * @param tag
	 * @param path
	 */
	Track(Tag tag, Path path) {
		name = tag.getFirst(FieldKey.TITLE)
		artist = tag.getFirst(FieldKey.ARTIST)
		album = tag.getFirst(FieldKey.ALBUM)
		albumArtist = tag.getFirst(FieldKey.ALBUM_ARTIST)
		track = tag.getFirst(FieldKey.TRACK)
		this.path = path
	}

	/*
	 * override equals & hashCode
	 * http://tech-tips-tridib.blogspot.com/2012/02/overriding-equals-in-groovy.html
	 * https://myshittycode.com/2013/10/29/groovy-java-lang-stackoverflowerror-when-implementing-equals/
	 */

	@Override
	boolean equals(Object o) {
		if (this.is(o)){
			return true
		}
		if (o==null || !(o instanceof Track)) {
			return false
		}
		Track rhs = (Track) o;
		return new EqualsBuilder()
				.append(name, rhs?.name)
				.append(album, rhs?.album)
				.append(artist, rhs?.artist)
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(name)
				.append(album)
				.append(artist)
				.toHashCode();
	}

	/**
	 * Convert track to json
	 * @return track as json string
	 */
	String toJson() {
		JsonBuilder builder = new JsonBuilder()
		builder {
			name name
			artist artist
			album album
			albumArtist albumArtist
			track track
			path path.toString()
		}
		//		JsonOutput.toJson(builder)
		builder
	}

	/**
	 * Test reading tracks, printing, indexing and searching
	 * @param args
	 */
	static main(args) {
		String pathName = 'C:\\Users\\Glen\\Music'
		//				String pathName = 'C:\\Users\\Public\\Music\\Sample Music'

		def tracks = getFileTracks(pathName)

		println '--------- print tracks'
		for (t in tracks) {
			println t
		}

		println '--------- print json tracks'
		for (t in tracks) {
			println t.toJson()
		}

		bulkLoadJson(tracks)


		//		indexTracks(tracks)
		//
		//		//search test
		//		println '-------- search'
		//		searchTest('cheese')
	}

	/**
	 * Create a bulk load file for Elasticsearch
	 * @param tracks list of Track
	 */
	static bulkLoadJson(Track[] tracks) {
		new File('mp3.json').withWriter{ out ->
			tracks.eachWithIndex { track, index ->
				out.println "{\"index\":{\"_id\":\"$index\"}}"
				out.println track.toJson()
			}
		}
	}

	static indexTracks(Track[] tracks) {
		println '------- index tracks'
		Directory dir = FSDirectory.open(Paths.get(LUCENE_INDEX))
		Analyzer analyzer = new StandardAnalyzer()
		IndexWriterConfig iwc = new IndexWriterConfig(analyzer)

		//		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND)
		iwc.setOpenMode(OpenMode.CREATE)
		IndexWriter writer = new IndexWriter(dir, iwc)
		writer.withCloseable {
			for (t in tracks) {
				t.index(writer)
			}
		}
	}

	/**
	 * Recursively get tracks from a directory
	 * @param pathName
	 * @return list of Track
	 */
	static Track[] getFileTracks(String pathName) {
		// disable jul logging output
		java.util.logging.Logger globalLogger = java.util.logging.Logger.getLogger("");
		Handler[] handlers = globalLogger.getHandlers();
		for (Handler handler : handlers) {
			globalLogger.removeHandler(handler);
		}

		def tracks = []
		Paths.get(pathName).eachFileRecurse(FILES) { path ->
			if (path.toString() ==~ /.*\.(mp3)$/) {
				MP3File mf = new MP3File(path.toFile(), MP3File.LOAD_ALL, true)
				Tag tag = mf.getTag()
				tracks << new Track(tag, path)
			}
		}
		return tracks
	}

	/**
	 * Index track to lucene
	 * @param writer
	 */
	void index(IndexWriter writer) {
		//TODO: add other fields, different way to do constants??

		// add track to index
		Document doc = new Document()
		Field artist = new Field(ARTIST_FIELD, artist, TextField.TYPE_STORED)
		Field name = new Field(NAME_FIELD, name, TextField.TYPE_STORED)
		Field album = new Field(ALBUM_FIELD, album, TextField.TYPE_STORED)
		doc.add(artist)
		doc.add(name)
		doc.add(album)
		writer.addDocument(doc)
	}

	/**
	 * Search lucene index
	 * @param queryString lucene query
	 */
	static void searchTest(String queryString) {
		//TODO: withCloseable
		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(LUCENE_INDEX)))
		reader.withCloseable {
			IndexSearcher searcher = new IndexSearcher(reader)
			Analyzer analyzer = new StandardAnalyzer()

			// single field
			//		QueryParser parser = new QueryParser(NAME_FIELD, analyzer)

			// multi field
			String[] fields = [ARTIST_FIELD, NAME_FIELD, ALBUM_FIELD]
			QueryParser parser = new MultiFieldQueryParser(fields, analyzer)

			Query query = parser.parse(queryString)
			TopDocs results = searcher.search(query, 100)

			ScoreDoc[] hits = results.scoreDocs
			println "hits: ${hits.size()}"

			for (sd in hits) {
				//			println sd
				//			println sd.dump()
				Document doc = searcher.doc(sd.doc)
				println "artist:${doc.get(ARTIST_FIELD)} name:${doc.get(NAME_FIELD)} album:${doc.get(ALBUM_FIELD)}"
			}
		}
	}

}
