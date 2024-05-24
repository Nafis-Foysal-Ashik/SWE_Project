package com.example.study;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static java.util.regex.Pattern.matches;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class

ChemistryActivityUITest {

    @Rule
    public ActivityScenarioRule<ChemistryActivity> activityScenarioRule = new ActivityScenarioRule<>(ChemistryActivity.class);
    //UI testing for correct ans of any corresponding quesion
    @Test
    public void testQuizFlow() {
        onView(withId(R.id.question_text))
                .check(ViewAssertions.matches(withText("What is the symbol for sodium?")));

        onView(withId(R.id.answer_edit_text))
                .perform(typeText("Na"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

         //Verify the next question
        onView(withId(R.id.question_text))
                .check(ViewAssertions.matches(withText("What is the basic unit of mass in the SI system?")));

        // Enter incorrect answer and submit
        onView(withId(R.id.answer_edit_text))
                .perform(typeText("kilogram"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        // Verify the next question
        onView(withId(R.id.question_text))
                .check(ViewAssertions.matches(withText("What is the process of converting a gas into a liquid?")));

        onView(withId(R.id.answer_edit_text))
                .perform(typeText("condensation"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());
    }

    //UI testing for question is displayed correctly or not
    @Test
    public void testInitialQuestionDisplayed() {
        // Check if the first question is displayed correctly
        onView(withId(R.id.question_text))
                .check(matches(withText("What is the symbol for sodium?")));
    }

    @Test
    public void testSecondQuestionDisplayed() {
        // Check if the second question is displayed correctly after answering the first question
        onView(withId(R.id.answer_edit_text)).perform(typeText("Na"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        onView(withId(R.id.question_text))
                .check(matches(withText("What is the basic unit of mass in the SI system?")));
    }

    @Test
    public void testThirdQuestionDisplayed() {
        // Check if the third question is displayed correctly after answering the first two questions
        onView(withId(R.id.answer_edit_text)).perform(typeText("Na"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        onView(withId(R.id.answer_edit_text)).perform(typeText("gram"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        onView(withId(R.id.question_text))
                .check(matches(withText("What is the process of converting a gas into a liquid?")));
    }

    //UI testing when the edit text view is empty and if the button is pressed if does not go to the next question
    @Test
    public void testSubmitButtonWithEmptyAnswer() {
        onView(withId(R.id.question_text))
                .check(matches(withText("What is the symbol for sodium?")));

        onView(withId(R.id.submit_button)).perform(click());

        // Verify the question text has not changed (still the first question)
        onView(withId(R.id.question_text))
                .check(matches(withText("What is the symbol for sodium?")));
    }

    //UI testing if the ans is correct then it will go to the next question or not
    @Test
    public void testAnswerCorrectNextQuestion() {
        // Answer first question correctly
        onView(withId(R.id.answer_edit_text)).perform(typeText("Na"), closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());

        // Check if the second question is displayed
        onView(withId(R.id.question_text))
                .check(matches(withText("What is the basic unit of mass in the SI system?")));
    }

    //UI testing if the ans is incorrect then it will remain in the same question
//    @Test
//    public void testAnswerIncorrectRemainSameQuestion() {
//        // Answer first question incorrectly
//        onView(withId(R.id.answer_edit_text)).perform(typeText("Vul Answere"), closeSoftKeyboard());
//        onView(withId(R.id.submit_button)).perform(click());
//
//        // Check if the first question is still displayed
//        onView(withId(R.id.question_text))
//                .check(matches(withText("What is the symbol for sodium?")));
//
//        // Check if the answer EditText and submit button are still displayed
//        onView(withId(R.id.answer_edit_text)).check(matches(isDisplayed()));
//        onView(withId(R.id.submit_button)).check(matches(isDisplayed()));
//    }

}

//}
