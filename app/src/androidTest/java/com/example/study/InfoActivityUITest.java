package com.example.study;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class InfoActivityUITest {
    @Rule
    public ActivityScenarioRule<InfoActivity> activityActivityScenarioRule = new ActivityScenarioRule<>(InfoActivity.class);

    @Test
    public void testButtonClick_1() {
        // Click the button once
        onView(withId(R.id.infobtn)).perform(click());

        // Check if the TextView displays "Nafis"
        onView(withId(R.id.infotv)).check(matches(withText("Nafis")));
    }

    @Test
    public void testButtonClick_2() {
        // Click the button twice
        onView(withId(R.id.infobtn)).perform(click());
        onView(withId(R.id.infobtn)).perform(click());

        // Check if the TextView displays "Hafiz"
        onView(withId(R.id.infotv)).check(matches(withText("Hafiz")));
    }

    @Test
    public void testButtonClick_3() {
        // Click the button three times
        onView(withId(R.id.infobtn)).perform(click());
        onView(withId(R.id.infobtn)).perform(click());
        onView(withId(R.id.infobtn)).perform(click());

        // Check if the TextView displays "Tomal"
        onView(withId(R.id.infotv)).check(matches(withText("Tomal")));
    }
}
