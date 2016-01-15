package indexTest;

import java.io.Reader;

import org.apache.lucene.analysis.charfilter.MappingCharFilter;
import org.apache.lucene.analysis.charfilter.NormalizeCharMap;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.util.StopwordAnalyzerBase;

// from http://stackoverflow.com/questions/15235126/lucene-4-1-how-split-words-that-contains-dots-when-indexing
public final class MyAnalyzer extends StopwordAnalyzerBase {
  private int maxTokenLength = 255;
  public MyAnalyzer() {
    super(StopAnalyzer.ENGLISH_STOP_WORDS_SET);
  }

//  @Override
//  protected TokenStreamComponents createComponents
//      (final String fieldName, final Reader reader) {
//    final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
//    src.setMaxTokenLength(maxTokenLength);
//    TokenStream tok = new StandardFilter(matchVersion, src);
//    tok = new LowerCaseFilter(matchVersion, tok);
//    tok = new StopFilter(matchVersion, tok, stopwords);
//    return new TokenStreamComponents(src, tok) {
//      @Override
//      protected void setReader(final Reader reader) throws IOException {
//        src.setMaxTokenLength(MyAnalyzer.this.maxTokenLength);
//        super.setReader(reader);
//      }
//    };
//  }

  @Override
  protected Reader initReader(String fieldName, Reader reader) {
    NormalizeCharMap.Builder builder = new NormalizeCharMap.Builder();
    builder.add(".", " ");
    builder.add("_", " ");
    NormalizeCharMap normMap = builder.build();
    return new MappingCharFilter(normMap, reader);
  }

@Override
protected TokenStreamComponents createComponents(String fieldName) {
	return null;
}
}