package chef.master.masterchef;

import android.app.Application;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import chef.master.masterchef.view.ViewModule;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class RecipeApplication extends Application{

    public static RecipeComponent injector;
    private Tracker mTracker;


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        injector = DaggerRecipeComponent.builder().viewModule(new ViewModule(this)).build();
        if (BuildConfig.FLAVOR.equals("mock")) {
            injector = DaggerMockRecipeComponent.builder().viewModule(new ViewModule(this)).build();
        }
        else {
            injector = DaggerRecipeComponent.builder().viewModule(new ViewModule(this)).build();
        }
    }

    public void setInjector(RecipeComponent appComponent) {
        injector = appComponent;
        injector.inject(this);
    }

    /**
     * Gets the default {@link Tracker} for this {@link Application}.
     * @return tracker
     */
    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }

}
