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

    // Setup method to initialize necessary components before each test
    @Before
    public void setUp() {
        Intents.init(); // Initialize Intents for handling intents in tests
        galleryActivityScenario = ActivityScenario.launch(GalleryActivity.class); // Launch GalleryActivity
    }

    // Teardown method to release resources after each test
    @After
    public void tearDown() {
        galleryActivityScenario.close(); // Close GalleryActivity
        Intents.release(); // Release Intents
    }

    // Test method to verify the deletion of an entry from the gallery
    @Test
    public void testDeletingEntry() {
        int initialSize = EntryStorage.getImageList().getImageList().size(); // Get initial size of image list

        onView(withId(R.id.galleryList)).check(matches(isDisplayed())); // Check if gallery list is displayed

        onData(anything()).inAdapterView(withId(R.id.galleryList)).atPosition(0).perform(scrollTo()); // Scroll to first item in gallery list

        onData(anything()).inAdapterView(withId(R.id.galleryList)).atPosition(0).perform(click()); // Click on first item in gallery list to delete it

        // Assert that the size of the image list decreases by one after deletion
        if (initialSize > 3) {
            assertTrue(EntryStorage.getImageList().getImageList().size() < initialSize);
            assertEquals(EntryStorage.getImageList().getImageList().size(), initialSize - 1);
        }

        // Assert that the size of the image list remains at least 3 after deletion
        assertTrue(EntryStorage.getImageList().getImageList().size() >= 3);
    }
}
