package chef.master.masterchef.interactor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
@Module
public class InteractorModule {
    @Provides
    public RecipeInteractor getRecipeInteractor(){
        return new RecipeInteractor();
    }
}
