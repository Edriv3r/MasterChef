package chef.master.masterchef;

import javax.inject.Singleton;

import chef.master.masterchef.interactor.InteractorModule;
import chef.master.masterchef.interactor.RecipeInteractor;
import chef.master.masterchef.model.ModelModule;
import chef.master.masterchef.presenter.MainPresenter;
import chef.master.masterchef.view.MainActivity;
import chef.master.masterchef.view.ViewModule;
import dagger.Component;

/**
 * Created by mobsoft on 2016. 04. 11..
 */
@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class})
public interface MVPComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(RecipeInteractor recipeInteractor);
}
