package com.example.thequizapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class QuizScoreUpdateTest {

    @Rule
    public ActivityScenarioRule<QuizActivity> activityScenarioRule = new ActivityScenarioRule<>(QuizActivity.class);

    @Test
    public void testScoreUpdateForCorrectAnswer() {
        // Perform action to answer a question correctly
        selectCorrectAnswer();

        // Verify that the score is updated correctly
        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 1/1")));
    }

    @Test
    public void testScoreUpdateForIncorrectAnswer() {
        // Perform action to answer a question incorrectly
        selectIncorrectAnswer();

        // Verify that the score is updated correctly
        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 0/1")));
    }

    private void selectCorrectAnswer() {
        // Perform action to answer a question correctly
        onView(withId(R.id.button1)).perform(click());
    }

    private void selectIncorrectAnswer() {
        // Perform action to answer a question incorrectly
        onView(withId(R.id.button2)).perform(click());
    }
}
