package chef.master.masterchef.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.orm.SugarContext;

import javax.inject.Inject;

import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.RecipesListPresenter;

public class RecipesRecipeActivity extends AppCompatActivity implements RecipeView {

    @Inject
    RecipesListPresenter recipesListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        RecipeApplication.injector.inject(this);
        Recipe.listAll(Recipe.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipesListPresenter.attachView(this);

        Recipe recipe = new Recipe("Lasange", "foo1", "foo2", "foo3");
        recipe.save();
        showRecipe(Recipe.findById(Recipe.class, 1));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recipesListPresenter.detachView();
    }

    @Override
    public void showRecipe(Recipe r) {
        ((TextView)findViewById(R.id.tvRecipeName)).setText(r.getTitle());
        ((TextView)findViewById(R.id.tvRecipeDescription)).setText(r.getDescription());
        ((TextView)findViewById(R.id.tvRecipeIngredients)).setText(r.getIngredients());
        ((TextView)findViewById(R.id.tvRecipeDirections)).setText(r.getDirections());
    }
}
