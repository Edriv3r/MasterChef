package chef.master.masterchef.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.adapter.RecipesAdapter;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.RecipesListPresenter;

public class RecipesListActivity extends AppCompatActivity implements RecipeView {
    private List<Recipe> recipesList = new ArrayList<>();

    @Inject
    RecipesListPresenter recipesListPresenter;

    RecipesAdapter recipesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        RecipeApplication.injector.inject(this);
        Recipe.findById(Recipe.class, (long) 1);
        Recipe.listAll(Recipe.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvRecipes);

        recipesAdapter = new RecipesAdapter(recipesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recipesAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipesListPresenter.attachView(this);
        recipesList = Recipe.listAll(Recipe.class);
        showRecipe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        recipesListPresenter.detachView();
    }

    @Override
    public void showRecipe() {
        recipesAdapter.setList(recipesList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.online:
                Intent intentOnline = new Intent(this, RecipesListActivity.class);
                this.startActivity(intentOnline);
                break;
            case R.id.offline:
                Intent intentOffline = new Intent(this, DownloadedRecipesActivity.class);
                this.startActivity(intentOffline);
                break;
            case R.id.create:
                Intent intentCreate = new Intent(this, UploadRecipeActivity.class);
                this.startActivity(intentCreate);
                break;
            case R.id.about:
                Intent intentAbout = new Intent(this, AboutActivity.class);
                this.startActivity(intentAbout);
                break;
        }
        return true;
    }
}
