package chef.master.masterchef;

import android.app.Application;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class MVPApplication extends Application{
    public static MVPComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
