package com.example.study;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
class MathActivityIntegrationTest {

    @Rule
    public ActivityTestRule<MathActivity> activityRule =
            new ActivityTestRule<>(MathActivity.class);

    @Test
    public void testButtonClickIncreasesCount() {
        // Click each button and verify if count increases
        for (int i = 0; i < 10; i++) {
            int buttonId = activityRule.getActivity().getResources()
                    .getIdentifier("q" + (i + 1) + "bm", "id",
                            activityRule.getActivity().getPackageName());
            Espresso.onView(ViewMatchers.withId(buttonId))
                    .perform(ViewActions.click());
        }
        Espresso.onView(ViewMatchers.withId(R.id.submath))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("Your Score : 10"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testSubmitButtonShowsScore() {
        // Click each button and submit
        for (int i = 0; i < 5; i++) {
            int buttonId = activityRule.getActivity().getResources()
                    .getIdentifier("q" + (i + 1) + "bm", "id",
                            activityRule.getActivity().getPackageName());
            Espresso.onView(ViewMatchers.withId(buttonId))
                    .perform(ViewActions.click());
        }
        Espresso.onView(ViewMatchers.withId(R.id.submath))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withText("Your Score : 5"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }
}
