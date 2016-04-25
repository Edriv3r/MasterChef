package chef.master.masterchef;

import android.app.Application;

import com.orm.SugarContext;

import chef.master.masterchef.view.ViewModule;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class RecipeApplication extends Application{

    public static RecipeComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerRecipeComponent.builder().viewModule(new ViewModule(this)).build();
    }
}
