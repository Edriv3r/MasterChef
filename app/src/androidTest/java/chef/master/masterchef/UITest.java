package chef.master.masterchef;

import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import chef.master.masterchef.view.RecipesListActivity;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
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
    public void testMove2About() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("About")).perform(click());
        onView(withText("About Us")).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void testMove2Create() {
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());
        onView(withText("Create")).perform(click());
        onView(withText("Recipe name")).check(ViewAssertions.matches(isDisplayed()));
    }
    @Test
    public void testMove2Detail() {
        onView(withId(R.id.rvRecipes)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));
        onView(withText("Lasagne")).check(ViewAssertions.matches(isDisplayed()));
    }
}
