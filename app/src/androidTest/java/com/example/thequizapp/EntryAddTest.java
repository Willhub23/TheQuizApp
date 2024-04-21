package com.example.thequizapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertEquals;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.runner.AndroidJUnit4;

import com.example.thequizapp.model.EntryStorage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EntryAddTest {

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
        int initialSize = EntryStorage.getImageList().getImageList().size();
        Intents.intending(hasAction(Intent.ACTION_GET_CONTENT)).respondWith(new Instrumentation.ActivityResult(Activity.RESULT_OK, new Intent()));

        onView(withId(R.id.button_add_image)).perform(click());

        onView(withId(R.id.edit_text_name)).perform(ViewActions.typeText("Sverige"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.button_save)).perform(click());

        assertEquals(initialSize + 1, EntryStorage.getImageList().getImageList().size());
    }



}
