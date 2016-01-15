package gwm.analyzer;

import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.WhitespaceAnalyzer;
import org.apache.lucene.analysis.snowball.SnowballAnalyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.util.Version;

import lucenewriterexample.TokenizewithAnalyzer;

public class AnalyzerTest {
	public static void main(String[] args) {
		String text = "this is only a test some_pdf_file.pdf some.other.pdf.file.pdf";
		System.out.println("text:" + text);
		
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
		analyerTest(text, analyzer);

		analyzer = new SimpleAnalyzer(Version.LUCENE_42);
		analyerTest(text, analyzer);
		
		analyzer = new WhitespaceAnalyzer(Version.LUCENE_42);
		analyerTest(text, analyzer);
		
		analyzer = new StopAnalyzer(Version.LUCENE_42);
		analyerTest(text, analyzer);
		
		analyzer = new SnowballAnalyzer(Version.LUCENE_42, "English");
		analyerTest(text, analyzer);
		
		
	}

	private static void analyerTest(String text, Analyzer analyzer) {
		List<String> ss = TokenizewithAnalyzer.tokenizeString(analyzer, text);
		System.out.print(analyzer.getClass().getName() + "==>" + ss + " \n");
	}

}
