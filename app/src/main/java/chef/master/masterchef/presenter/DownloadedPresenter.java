package chef.master.masterchef.presenter;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.view.RecipeView;

/**
 * Created by mobsoft on 2016. 04. 25..
 */
public class DownloadedPresenter extends Presenter<RecipeView>{
    @Inject
    public RecipeInteractor interactor;

    public DownloadedPresenter() {
        RecipeApplication.injector.inject(this);
    }
}
