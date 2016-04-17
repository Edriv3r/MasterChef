package chef.master.masterchef;

import android.app.Application;

import chef.master.masterchef.view.ViewModule;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class MVPApplication extends Application{

    public static MVPComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        injector = DaggerMVPComponent.builder().viewModule(new ViewModule(this)).build();
    }
}
