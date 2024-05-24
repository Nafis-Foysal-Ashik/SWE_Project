package com.example.study;

import static androidx.core.app.NotificationCompat.getColor;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasBackground;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.graphics.Color;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.google.firebase.annotations.concurrent.Background;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class BiologyActivityTest {

    @Rule
    public ActivityScenarioRule<BiologyActivity> activityRule =
            new ActivityScenarioRule<>(BiologyActivity.class);

    @Test
    public void InitialQuestion() {
        // Check initial question
        Espresso.onView(ViewMatchers.withId(R.id.question_number))
                .check(ViewAssertions.matches(withText("Question: 1")));
    }

    @Test
    public void testNextQuestionNavigation() {
        // option a (answer)
        Espresso.onView(ViewMatchers.withId(R.id.option_a)).perform(ViewActions.click());

        // Click next button
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());

        // Check second question
        Espresso.onView(ViewMatchers.withId(R.id.question_number))
                .check(ViewAssertions.matches(withText("Question: 2")));
    }

    @Test
    public void testPreviousQuestionNavigation() {
        // option a clicked, correct answer a, question 1
        Espresso.onView(ViewMatchers.withId(R.id.option_a)).perform(ViewActions.click());
        // question 2
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());

        // privious button -> question 1
        Espresso.onView(ViewMatchers.withId(R.id.previous_button)).perform(ViewActions.click());

        // previous button -> first question
        Espresso.onView(ViewMatchers.withId(R.id.question_number))
                .check(ViewAssertions.matches(withText("Question: 1")));
    }

    @Test
    public void testShowAnswerHighlight() {
        // Select answer for the first question
        Espresso.onView(ViewMatchers.withId(R.id.option_a)).perform(ViewActions.click());

        // Click show answer button
        Espresso.onView(ViewMatchers.withId(R.id.show_answer)).perform(ViewActions.click());

        // Check that the correct answer is highlighted in green
        Espresso.onView(ViewMatchers.withId(R.id.option_a)).check(ViewAssertions.matches(BackgroundColorMatcher.withBackgroundColor(Color.GREEN)));

    }

    @Test
    public void testNoAnswerSelection() {
        //  next button (without selecting an answer)
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.question_number))
                .check(ViewAssertions.matches(ViewMatchers.withText("Question: 2")));

    }
    @Test
    public void testHighlightWrongAnswer() {
        // Click on the next button to move to the next question
        Espresso.onView(withId(R.id.next_button)).perform(click());

        // Check if the options are displayed
        Espresso.onView(withId(R.id.option_a)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.option_b)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.option_c)).check(ViewAssertions.matches(isDisplayed()));
        Espresso.onView(withId(R.id.option_d)).check(ViewAssertions.matches(isDisplayed()));

        // Select an incorrect answer (option A)
        Espresso.onView(withId(R.id.option_b)).perform(click());

        // Click on the next button again to check for highlighting of the wrong answer
        Espresso.onView(withId(R.id.show_answer)).perform(click());

        // Check if the wrong answer (option A) is highlighted in red
        Espresso.onView(ViewMatchers.withId(R.id.option_b)).check(ViewAssertions.matches(BackgroundColorMatcher.withBackgroundColor(Color.RED)));
    }

    @Test
    public void testTotalMarks() {
        // Select correct answers for the first 3 questions
        Espresso.onView(ViewMatchers.withId(R.id.option_a)).perform(ViewActions.click()); //  correct
        Espresso.onView(ViewMatchers.withId(R.id.show_answer)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.option_b)).perform(ViewActions.click()); // not correct
        Espresso.onView(ViewMatchers.withId(R.id.show_answer)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.option_b)).perform(ViewActions.click()); //  correct
        Espresso.onView(ViewMatchers.withId(R.id.show_answer)).perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.next_button)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.result)).perform(ViewActions.click());

        Espresso.onView(ViewMatchers.withId(R.id.show_total_mark))
                .check(ViewAssertions.matches(withText("Total Marks: 2")));
    }





}





