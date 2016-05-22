package chef.master.masterchef;

import javax.inject.Singleton;

import chef.master.masterchef.interactor.InteractorModule;
import chef.master.masterchef.network.mock.MockNetworkModule;
import dagger.Component;

/**
 * Created by Ra's Al Ghul on 2016. 05. 22..
 */
@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class})
public interface TestComponent extends RecipeComponent {
}

