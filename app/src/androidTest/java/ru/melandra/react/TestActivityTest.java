package ru.melandra.react;

import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import ru.melandra.react.Test.TestActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

public class TestActivityTest {

    @Rule
    public ActivityTestRule<TestActivity> rule = new ActivityTestRule<>(TestActivity.class);

    @Test
    public void labelAfterActionButonClicked() {
        onView(withId(R.id.actionButton)).perform(click());
        onView(withId(R.id.labelTextView)).check(matches(withText("Sample text")));
    }
}
