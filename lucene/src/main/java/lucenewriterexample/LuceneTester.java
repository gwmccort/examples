/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucenewriterexample;

/**
 *
 * @author Niraj
 */
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
import org.apache.lucene.util.Version;

public class LuceneTester {

	public static void main(String[] args) {
		LuceneTester tester;

		tester = new LuceneTester();

		try {
			tester.displayTokenUsingStandardAnalyzer();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void displayTokenUsingStandardAnalyzer() throws IOException {
		String text = "Lucene is a simple yet powerful java based search library.";
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_42);
		List<String> ss = TokenizewithAnalyzer.tokenizeString(analyzer, text);
		System.out.print("==>" + ss + " \n");
		TokenStream tokenStream = analyzer.tokenStream(LuceneConstants.CONTENTS, new StringReader(text));

		TermToBytesRefAttribute term = tokenStream.addAttribute(TermToBytesRefAttribute.class);
		while (tokenStream.incrementToken()) {
			System.out.print("[" + term.toString() + "] ");
		}
		TokenizewithAnalyzer.tokenizeString(analyzer, "Hello this is a text. I am looking for a chrome");
	}
}
