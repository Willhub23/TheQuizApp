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

import java.util.Random;

@RunWith(AndroidJUnit4.class)
public class QuizScoreUpdateTest {

    @Rule
    public ActivityScenarioRule<QuizActivity> activityScenarioRule = new ActivityScenarioRule<>(QuizActivity.class);

    @Test
    public void testScoreUpdateInQuizActivity() {
        // Perform actions to answer questions
        // For example, clicking on a randomly selected answer button
        selectRandomAnswer();
        // Verify that the score is updated correctly
        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 1/1"))); // Assuming the first answer is correct, so the score should be "1/1"

        // Or if you expect the score to be "0/1" for an incorrect answer
        selectRandomAnswer();
        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 0/1"))); // Assuming the second answer is incorrect, so the score should be "0/1"
    }

    private void selectRandomAnswer() {
        // Define an array of button IDs representing the answer options
        int[] answerButtonIds = {R.id.button1, R.id.button2, R.id.button3};

        // Generate a random index to select a button ID from the array
        int randomIndex = new Random().nextInt(answerButtonIds.length);

        // Perform a click action on the randomly selected answer button
        onView(withId(answerButtonIds[randomIndex])).perform(click());
    }

}
