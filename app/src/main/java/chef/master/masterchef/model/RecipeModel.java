package chef.master.masterchef.model;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class RecipeModel {

    protected Recipe recipe;


    @Inject
    public RecipeModel(){};

    public List<Recipe> fetchRecipes() {
        List<Recipe> values = Recipe.listAll(Recipe.class);
        return values;
    }

    public void insertRecipe(Recipe toInsert) {
        toInsert.save();
    }
}
