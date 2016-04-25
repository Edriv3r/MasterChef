package chef.master.masterchef.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.AboutPresenter;

public class AboutActivity extends AppCompatActivity implements AboutView{

    @Inject
    AboutPresenter aboutPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected void onStart() {
        super.onStart();
        aboutPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        aboutPresenter.detachView();
    }

    @Override
    public void showAbout() {

    }
}
