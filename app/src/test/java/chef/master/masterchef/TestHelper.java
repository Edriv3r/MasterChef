package chef.master.masterchef;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by Ra's Al Ghul on 2016. 05. 22..
 */
public class TestHelper {

    public static void setTestInjector() {
        RecipeApplication application = (RecipeApplication) RuntimeEnvironment.application;
        RecipeComponent injector = DaggerTestComponent.builder().testModule(new TestModule(application.getApplicationContext())).build();
        application.setInjector(injector);
    }
}