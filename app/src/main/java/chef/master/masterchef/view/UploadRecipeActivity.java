package chef.master.masterchef.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.UploadPresenter;

public class UploadRecipeActivity extends AppCompatActivity implements RecipeView{

    @Inject
    UploadPresenter uploadPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);
    }

    @Override
    protected void onStart() {
        super.onStart();
        uploadPresenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        uploadPresenter.detachView();
    }

    @Override
    public void showRecipe(Recipe r) {

    }
}
