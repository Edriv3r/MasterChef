package chef.master.masterchef;

import javax.inject.Singleton;

import chef.master.masterchef.interactor.InteractorModule;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.model.ModelModule;
import chef.master.masterchef.network.prod.NetworkModule;
import chef.master.masterchef.presenter.AboutPresenter;
import chef.master.masterchef.presenter.DetailPresenter;
import chef.master.masterchef.presenter.DownloadedPresenter;
import chef.master.masterchef.presenter.RecipesListPresenter;
import chef.master.masterchef.presenter.UploadPresenter;
import chef.master.masterchef.view.RecipesListActivity;
import chef.master.masterchef.view.ViewModule;
import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface RecipeComponent {
    void inject(RecipesListActivity recipesListActivity);

    void inject(RecipesListPresenter recipesListPresenter);
    void inject(AboutPresenter aboutPresenter);
    void inject(DetailPresenter detailPresenter);
    void inject(DownloadedPresenter downloadedPresenter);
    void inject(UploadPresenter uploadPresenter);
    void inject(RecipeInteractor recipeInteractor);
    void inject(RecipeApplication recipeApplication);
}
