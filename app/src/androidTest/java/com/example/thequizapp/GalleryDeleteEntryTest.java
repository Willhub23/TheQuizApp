package com.example.thequizapp;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.CoreMatchers.anything;
import static org.junit.Assert.assertTrue;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.intent.Intents;
import androidx.test.runner.AndroidJUnit4;

import com.example.thequizapp.model.EntryStorage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GalleryDeleteEntryTest {

    private ActivityScenario<GalleryActivity> galleryActivityScenario;
    @Before
    public void setUp() {
        Intents.init();
        galleryActivityScenario = ActivityScenario.launch(GalleryActivity.class);
    }

    @After
    public void tearDown() {
        galleryActivityScenario.close();
        Intents.release();
    }

    @Test
    public void testDeletingEntry() {
        int initialSize = EntryStorage.getImageList().getImageList().size();

        onView(withId(R.id.galleryList)).check(matches(isDisplayed()));

        onData(anything()).inAdapterView(withId(R.id.galleryList)).atPosition(0).perform(scrollTo());

        onData(anything()).inAdapterView(withId(R.id.galleryList)).atPosition(0).perform(click());


        if (initialSize > 3) {
            assertTrue(EntryStorage.getImageList().getImageList().size() < initialSize);
            assertEquals(EntryStorage.getImageList().getImageList().size(), initialSize - 1);
        }
        assertTrue(EntryStorage.getImageList().getImageList().size() >= 3);
    }


}
