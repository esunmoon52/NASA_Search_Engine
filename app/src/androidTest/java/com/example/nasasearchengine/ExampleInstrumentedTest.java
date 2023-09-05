package com.example.nasasearchengine;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.nasasearchengine", appContext.getPackageName());
    }

    @Test
    public void sameResultsNumbers() {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        /** would have set up an Activity Thread to simulate a user
         * searching and getting results. This test would have checked whether the amount of cards
         * displayed on the screen is equal to the number of search results
         */
    }

}