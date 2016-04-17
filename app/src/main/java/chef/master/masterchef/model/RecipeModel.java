package chef.master.masterchef.model;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
public class RecipeModel {

    protected Recipe recipe;

    public Recipe getRecipe(){
        recipe =  new Recipe("Steak", "Yummy", "Money", "Buy");
        return recipe;
    }
}
