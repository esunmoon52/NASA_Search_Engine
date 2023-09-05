package com.example.nasasearchengine;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {
    @Test
    public void validSearchResult() {
        String mockTitle = mock(String.class);
        String mockImage = mock(String.class);;
        String mockDescription = mock(String.class);;
        String mockDate = mock(String.class);;

        SearchResult mockSearchResult = new SearchResult(mockTitle, mockImage, mockDescription, mockDate);

        assertEquals(mockTitle, mockSearchResult.getTitle());
        assertEquals(mockImage, mockSearchResult.getImage());
        assertEquals(mockDescription, mockSearchResult.getDescription());
        assertEquals(mockDate, mockSearchResult.getDate());
    }

    @Test
    public void emptySearch() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. The test would assert whether or not the
         * the app attempts to search despite having no search terms.
         */
    }

    @Test
    public void urlOneTerm_isCorrect() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Checks if app can properly process one term
         * correctly (e.g. "Mars")
         */
    }

    @Test
    public void urlMultipleTerms_isCorrect() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Checks if app can properly process
         * more than one term correctly (e.g. "San Francisco")
         */
    }

    @Test
    public void resultsOnePage_isCorrect() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Checks if app can properly display
         * one page worth of results (i.e. 100 results or fewer)
         */
    }

    @Test
    public void resultsMorePages_isCorrect() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Checks if app can properly display more
         * than one page worth of results (i.e. more than 100 results). This would reload an
         * additional 100 onto the recycler view.
         */
    }

    @Test
    public void JSON_isLegitimate() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Would have created a fake JSON, similar
         * to the one in the GET response. Program should be able to determine whether it's a
         * JSON worth parsing.
         */
    }

    @Test
    public void catchesMissingAttribute_isTrue() {
        /** would have created an MainActivity Thread to simulate user tapping "search"
         * without typing anything into the search box. Would have created a fake JSON, similar
         * to the one in the GET response, without the "data" array. Program should be able to
         * catch this and throw an error.
         */
    }
}