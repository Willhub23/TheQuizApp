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
        mainActivityScenario = ActivityScenario.launch(MainActivity.class);
    }

    @After
    public void tearDown() {
        mainActivityScenario.close();
    }

    @Test
    public void testToOpenQuizActivity() {
        Espresso.onView(withId(R.id.quizButton))
                .perform(ViewActions.click());
        ActivityScenario<QuizActivity> quizActivityScenario = ActivityScenario.launch(QuizActivity.class);
        quizActivityScenario.onActivity(activity -> {

        });
    }

}