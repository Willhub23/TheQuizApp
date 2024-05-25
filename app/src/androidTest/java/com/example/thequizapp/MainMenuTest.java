package com.example.thequizapp;

import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainMenuTest {

    private ActivityScenario<MainActivity> mainActivityScenario;

    @Before
    public void setUp() {
        // Launch the MainActivity before each test
        mainActivityScenario = ActivityScenario.launch(MainActivity.class);
    }

    @After
    public void tearDown() {
        // Close the MainActivity after each test
        mainActivityScenario.close();
    }

    @Test
    public void testToOpenQuizActivity() {
        // Perform a click action on the quizButton
        Espresso.onView(withId(R.id.quizButton))
                .perform(ViewActions.click());

        // Launch the QuizActivity and perform assertions or additional actions
        ActivityScenario<QuizActivity> quizActivityScenario = ActivityScenario.launch(QuizActivity.class);
        quizActivityScenario.onActivity(activity -> {
            // Additional assertions or actions on the QuizActivity can be performed here
        });
    }
}
