package chef.master.masterchef.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

import chef.master.masterchef.MVPApplication;
import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MVPApplication.injector.inject(this);

        mainPresenter.doStuff();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.detachView();
    }

    @Override
    public void showRecipe(Recipe r) {
        ((TextView)findViewById(R.id.tvRecipeName)).setText(r.getTitle());
        ((TextView)findViewById(R.id.tvRecipeDescription)).setText(r.getDescription());
        ((TextView)findViewById(R.id.tvRecipeIngredients)).setText(r.getIngredients());
        ((TextView)findViewById(R.id.tvRecipeDirections)).setText(r.getDirections());
    }
}
