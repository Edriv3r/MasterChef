package chef.master.masterchef.presenter;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.view.AboutView;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class AboutPresenter extends Presenter<AboutView>  {
    @Inject
    public RecipeInteractor interactor;

    public AboutPresenter() {
        RecipeApplication.injector.inject(this);
    }
}
