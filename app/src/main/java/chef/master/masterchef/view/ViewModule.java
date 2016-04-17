package chef.master.masterchef.view;

import android.content.Context;

import javax.inject.Singleton;

import chef.master.masterchef.presenter.MainPresenter;
import dagger.Module;
import dagger.Provides;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
@Module
public class ViewModule {
    private Context context;

    public ViewModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter getMainPresenter() {
        return new MainPresenter();
    }
}
