package chef.master.masterchef.presenter;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.view.RecipeView;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class RecipesListPresenter extends Presenter<RecipeView>  {
    @Inject
    public RecipeInteractor interactor;

    public RecipesListPresenter() {
        RecipeApplication.injector.inject(this);
    }
}
