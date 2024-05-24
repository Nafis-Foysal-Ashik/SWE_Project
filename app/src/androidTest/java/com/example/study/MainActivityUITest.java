package com.example.study;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import org.junit.Rule;
import org.junit.Test;

public class MainActivityUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testMathImageViewClick() {
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();
        Espresso.onView(ViewMatchers.withId(R.id.math)).perform(ViewActions.click());
        // Add assertions to verify MathActivity starts
    }

    @Test
    public void testChemistryImageViewClick() {
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();
        Espresso.onView(ViewMatchers.withId(R.id.che)).perform(ViewActions.click());
        // Add assertions to verify ChemistryActivity starts
    }

    @Test
    public void testPhysicsImageViewClick() {
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();
        Espresso.onView(ViewMatchers.withId(R.id.phe)).perform(ViewActions.click());
        // Add assertions to verify PhysicsActivity starts
    }

    @Test
    public void testBiologyImageViewClick() {
        ActivityScenario<MainActivity> scenario = activityScenarioRule.getScenario();
        Espresso.onView(ViewMatchers.withId(R.id.bio)).perform(ViewActions.click());
        // Add assertions to verify BiologyActivity starts
    }
}
