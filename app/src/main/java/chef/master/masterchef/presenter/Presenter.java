package chef.master.masterchef.presenter;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public abstract class Presenter<S> {
    protected S view;

    public void attachView(S screen) {
        this.view = screen;
    }

    public void detachView() {
        this.view = null;
    }
}