package com.example.thequizapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.atomic.AtomicReference;

@RunWith(AndroidJUnit4.class)
public class QuizScoreUpdateTest {


    @Rule
    public ActivityScenarioRule<QuizActivity> activityScenarioRule = new ActivityScenarioRule<>(QuizActivity.class);

    @Before
    public void setUp() {
        // Initialize Espresso-Intents for handling intents
        Intents.init();
    }

    @After
    public void tearDown() {
        // Release Espresso-Intents after the test
        Intents.release();
    }

    @Test
    public void testScoreUpdateForCorrectAnswer() {
        // Use AtomicReference to store the correct answer
        AtomicReference<String> correctOption = new AtomicReference<>();
        activityScenarioRule.getScenario().onActivity(activity -> {
            // Capture the correct answer
            correctOption.set(activity.getCorrect().getName());
        });
        onView(allOf(withText(correctOption.get()), isDisplayed())).perform(click());

        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 1/1")));
    }
    @Test
    public void testScoreUpdateForIncorrectAnswer() {
        // Use AtomicReference to store the correct answer
        AtomicReference<String> correctOption = new AtomicReference<>();
        activityScenarioRule.getScenario().onActivity(activity -> {
            // Capture the correct answer
            correctOption.set(activity.getCorrect().getName());
        });

        // Perform a click action on a button that does not contain the correct answer text
        for (int i = 1; i <= 3; i++) {
            String buttonText = onView(withId(getButtonId(i))).toString();
            if (!buttonText.equals(correctOption.get())) {
                onView(withId(getButtonId(i))).perform(click());
                break;
            }
        }
        // Verify that the scoreTextView text does not change
        onView(withId(R.id.scoreTextView))
                .check(matches(withText("Points: 0/1")));
    }

    private int getButtonId(int index) {
        switch (index) {
            case 1:
                return R.id.button1;
            case 2:
                return R.id.button2;
            case 3:
                return R.id.button3;
            default:
                return -1;
        }
    }
}
