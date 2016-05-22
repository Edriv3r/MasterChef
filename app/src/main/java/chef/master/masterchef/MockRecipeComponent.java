package chef.master.masterchef;

import javax.inject.Singleton;

import chef.master.masterchef.interactor.InteractorModule;
import chef.master.masterchef.model.ModelModule;
import chef.master.masterchef.network.prod.NetworkModule;
import chef.master.masterchef.view.ViewModule;
import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class, InteractorModule.class, ModelModule.class, NetworkModule.class})
public interface MockRecipeComponent extends RecipeComponent{
}
