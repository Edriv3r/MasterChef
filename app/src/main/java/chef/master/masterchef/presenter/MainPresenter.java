package chef.master.masterchef.presenter;

import javax.inject.Inject;

import chef.master.masterchef.MVPApplication;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.view.MainView;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class MainPresenter extends Presenter<MainView>  {
    @Inject
    public RecipeInteractor interactor;

    public MainPresenter() {
        MVPApplication.injector.inject(this);
    }

    public void doStuff() {
        view.showRecipe(interactor.getRecipe());
    }
}
