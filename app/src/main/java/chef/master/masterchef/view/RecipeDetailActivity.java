package chef.master.masterchef.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.DetailPresenter;

public class RecipeDetailActivity extends AppCompatActivity implements RecipeView{

    @Inject
    DetailPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
    }

    @Override
    protected void onStart() {
        super.onStart();
        detailPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        detailPresenter.detachView();
    }

    @Override
    public void showRecipe(Recipe r) {

    }
}
