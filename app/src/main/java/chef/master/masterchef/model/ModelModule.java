package chef.master.masterchef.model;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
@Module
public class ModelModule {
    @Provides
    public RecipeModel getRecipeModel(){
        return new RecipeModel();
    }
}
