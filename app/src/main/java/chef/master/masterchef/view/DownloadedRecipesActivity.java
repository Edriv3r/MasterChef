package chef.master.masterchef.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.DownloadedPresenter;

public class DownloadedRecipesActivity extends AppCompatActivity implements RecipeView{

    @Inject
    DownloadedPresenter downloadedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloaded_recipes);
    }

    @Override
    protected void onStart() {
        super.onStart();
        downloadedPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        downloadedPresenter.detachView();
    }

    @Override
    public void showRecipe(Recipe r) {

    }
}
