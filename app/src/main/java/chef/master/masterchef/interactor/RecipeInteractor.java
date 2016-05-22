package chef.master.masterchef.interactor;

import java.util.List;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.model.RecipeModel;
import chef.master.masterchef.network.RecipesApi;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class RecipeInteractor {
    @Inject
    RecipeModel model;

    @Inject
    RecipesApi recipesApi;

    public RecipeInteractor() {
        RecipeApplication.injector.inject(this);
    }

    public void addRecipeToDb(Recipe recipe) {
        model.insertRecipe(recipe);
    }

    public void addRecipeToNetwork(Recipe toAdd) throws Exception {
        Response response = null;
        Call call = recipesApi.addPost();
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with post!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with post!");
        }
    }
    public List<Recipe> getRecipesFromDb() {
        return model.fetchRecipes();
    }

    public List<Recipe> getRecipeFromNetwork() throws Exception {
        Response<List<Recipe>> response = null;
        Call<List<Recipe>> call = recipesApi.recipesGet();
        try {
            response = call.execute();
        } catch (Exception e) {
            throw new Exception("Network error on execute with get!");
        }
        if (response.code() != 200) {
            throw new Exception("Network error with get!");
        }
        return response.body();
    }
}
