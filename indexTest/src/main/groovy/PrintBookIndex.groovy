import groovy.util.logging.Slf4j

import java.nio.file.Paths

import org.apache.lucene.document.Document
import org.apache.lucene.index.DirectoryReader
import org.apache.lucene.index.Fields
import org.apache.lucene.index.IndexReader
import org.apache.lucene.index.MultiFields
import org.apache.lucene.index.Terms
import org.apache.lucene.index.TermsEnum
import org.apache.lucene.store.FSDirectory

@Slf4j
class PrintBookIndex {

	private static final INDEX_PATH = 'index'

	static main(args) {

		IndexReader reader = DirectoryReader.open(FSDirectory.open(Paths.get(INDEX_PATH)))


		// list documents
		println reader.numDocs()
		for (i in 0..reader.numDocs()-1) {
			Document d = reader.document(i)
			println "i: $i d: $d"
		}

		// list terms

		//from: http://stackoverflow.com/questions/11148036/find-list-of-terms-indexed-by-lucene
		//		TermsEnum termEnum = reader.terms();
		//		while (termEnum.next()) {
		//			Term term = termEnum.term();
		//			System.out.println(term.text());
		//		}
		//		termEnum.close();

		//from: http://stackoverflow.com/questions/19208523/how-to-get-all-terms-in-index-directory-created-by-lucene-4-4-0
		Fields fields = MultiFields.getFields(reader);
		println "fields size: ${fields.size()}"
		for (String field : fields) {
			Terms terms = fields.terms(field);
			TermsEnum termsEnum = terms.iterator();
			int count = 0;
			while (termsEnum.next() != null) {
				println termsEnum
				count++;
			}
			println(count);
		}

		reader.close()
	}
}
