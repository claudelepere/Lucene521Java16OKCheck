package Makble;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchQueryParserTest {
  static TermQueryExample termQueryExample = new TermQueryExample();

  @BeforeAll
  static void setUpBeforeClass() throws Exception {
    termQueryExample.createIndex();
  }

  @AfterAll
  static void tearDownAfterClass() throws Exception {
    termQueryExample.getRamDirectory().close();
  }

  @BeforeEach
  void setUp() throws Exception {}

  @AfterEach
  void tearDown() throws Exception {}

  @Test
  void test() {
    System.out.println("=====================================================SearchQueryParserTest start");
    StringBuilder sB = new StringBuilder();
    sB.append(termQueryExample.searchQueryParser("lucene term vector"));
    sB.append(termQueryExample.searchQueryParser("lucene OR example"));
    sB.append(termQueryExample.searchQueryParser("lucene AND example AND author:sam"));
    System.out.println("=====================================================SearchQueryParserTest end\n");
    
    String expected =
    "length of top docs: 5\n" +
    "4\tSmith\tWhat is term vector in Lucene\n" +
    "3\tSmith\tLucene BooleanQuery is deprecated as of 5.3.0\n" +
    "0\tSam\tLucene index option analyzed vs not analyzed\n" +
    "1\tSam\tLucene field boost and query time boost example\n" +
    "2\tJack\tHow to do Lucene search highlight example\n" +
    "length of top docs: 5\n" +
    "1\tSam\tLucene field boost and query time boost example\n" +
    "2\tJack\tHow to do Lucene search highlight example\n" +
    "3\tSmith\tLucene BooleanQuery is deprecated as of 5.3.0\n" +
    "4\tSmith\tWhat is term vector in Lucene\n" +
    "0\tSam\tLucene index option analyzed vs not analyzed\n" +
    "length of top docs: 1\n" +
    "1\tSam\tLucene field boost and query time boost example\n";
    
    String actual = sB.toString();
    
    assertThat(actual, equalTo(expected));
  }

}
