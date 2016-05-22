package chef.master.masterchef;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import javax.inject.Inject;

import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.network.mock.RecipesMock;

import static chef.master.masterchef.TestHelper.setTestInjector;
import static org.junit.Assert.*;

/**
 * Created by Ra's Al Ghul on 2016. 05. 22..
 */
@RunWith(RobolectricDaggerTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class RecipeUnitTest {

    @Inject
    public RecipeInteractor interactor;

    @Before
    public void setup() throws Exception {
        setTestInjector();
        interactor = new RecipeInteractor();
    }

    @Test
    public void getterTest() throws Exception {
        Recipe recipe = new Recipe("name", "ingredients", "directions");
        assertEquals(recipe.getName().equals("name"), true);
    }

    @Test
    public void mockGetTest() throws Exception {
        RecipesMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            List<Recipe> recipeList = interactor.getRecipeFromNetwork();
            assertEquals(recipeList.get(1).getName(), RecipesMock.testRecipe1.getName());
            assertEquals(recipeList.get(2).getName(), RecipesMock.testRecipe2.getName());
        }
    }

    @Test
    public void mockAddTest() throws Exception {
        RecipesMock.resetList();
        if (BuildConfig.FLAVOR == "mock") {
            Recipe recipe = new Recipe("name", "ingredients", "directions");
            interactor.addRecipeToNetwork(recipe);
            List<Recipe> recipeList = interactor.getRecipeFromNetwork();
            assertEquals(recipeList.get(1).getName(), RecipesMock.testRecipe1.getName());
            assertEquals(recipeList.get(2).getName(), RecipesMock.testRecipe2.getName());
            assertEquals(recipeList.get(0).getName(), recipe.getName());
        }
    }
}

