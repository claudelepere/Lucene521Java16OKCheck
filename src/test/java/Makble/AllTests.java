package Makble;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ SearchSingleTermTest.class, SearchBooleanQueryTest.class, SearchQueryParserTest.class })
public class AllTests {
}
