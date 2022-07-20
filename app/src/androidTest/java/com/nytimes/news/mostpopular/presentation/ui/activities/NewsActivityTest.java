package PACKAGE_NAME;


import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NewsActivityTest {

    @Rule
    public ActivityScenarioRule<NewsActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(NewsActivity.class);

    @Test
    public void newsActivityTest() {
    }
}
