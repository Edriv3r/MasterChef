package chef.master.masterchef;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import chef.master.masterchef.view.RecipesListActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by mobsoft on 2016. 05. 23..
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class UITest {

    @Rule
    public ActivityRule<RecipesListActivity> mActivityRule = new ActivityRule(RecipesListActivity.class);

    @Test
    public void move2About() {
        onView(withId(R.id.about)).perform(click());
        onView(withText("AboutActivity")).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void move2Create() {
        onView(withId(R.id.create)).perform(click());
        onView(withText("UploadRecipeActivity")).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void move2Detail() {
        onView(withId(R.id.about)).perform(click());
        onView(withText("Activity2")).check(ViewAssertions.matches(isDisplayed()));
    }
}
