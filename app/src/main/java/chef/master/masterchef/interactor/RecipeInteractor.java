package chef.master.masterchef.interactor;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.model.RecipeModel;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class RecipeInteractor {
    @Inject
    RecipeModel model;

    public RecipeInteractor(){
        RecipeApplication.injector.inject(this);
    }

    public Recipe getRecipe(){
        return model.getRecipe();
    }
}
