package com.example.thequizapp;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EntryCountTest {

    private ActivityScenario<NewEntryActivity> newEntryActivityScenario;
    @Before
    public void setUp() {
        Intents.init();
        newEntryActivityScenario = ActivityScenario.launch(NewEntryActivity.class);
    }

    @After
    public void tearDown() {
        newEntryActivityScenario.close();
        Intents.release();
    }

    @Test
    public void testAddingEntry() {
        Intents.intending(IntentMatchers.anyIntent()).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, new Intent()));

        // Perform actions to add an entry
        Espresso.onView(ViewMatchers.withId(R.id.button_add_image)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.edit_text_name)).perform(ViewActions.typeText("Entry Name"));
        // You may need to handle the image selection here depending on how the image is added
        Espresso.onView(ViewMatchers.withId(R.id.button_save)).perform(ViewActions.click());
    }

    @Test
    public void testDeletingEntry() {

        // Perform actions to delete the entry
        // For example:
        Espresso.onData(Matchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.galleryList))
                .atPosition(0)
                .perform(ViewActions.click());

        // Verify that the entry is removed from the gallery list
        Espresso.onData(Matchers.anything())
                .inAdapterView(ViewMatchers.withId(R.id.galleryList))
                .atPosition(0)
                .check(ViewAssertions.doesNotExist());

        // Verify that the toast message is displayed
        Espresso.onView(withText("Entry deleted from database"))
                .check(ViewAssertions.matches(isDisplayed()));
    }

}
