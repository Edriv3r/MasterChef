package chef.master.masterchef;

import android.content.Context;

import chef.master.masterchef.model.ModelModule;
import chef.master.masterchef.view.ViewModule;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ra's Al Ghul on 2016. 05. 22..
 */
@Module
public class TestModule {

    private final ViewModule viewModule;
    private final ModelModule modelModule;

    public TestModule(Context context) {

        this.viewModule = new ViewModule(context);
        this.modelModule = new ModelModule();
    }

    @Provides
    public Context provideContext() {
        return viewModule.provideContext();
    }
}
