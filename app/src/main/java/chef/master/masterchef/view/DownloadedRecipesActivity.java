package chef.master.masterchef.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarContext;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.adapter.RecipesAdapter;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.presenter.DownloadedPresenter;

public class DownloadedRecipesActivity extends AppCompatActivity implements RecipeView{
    private List<Recipe> recipesList = new ArrayList<>();
    RecipesAdapter recipesAdapter;

    private Tracker mTracker;

    @Inject
    DownloadedPresenter downloadedPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SugarContext.init(this);
        Recipe.findById(Recipe.class, (long) 1);
        Recipe.listAll(Recipe.class);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvRecipes);

        recipesAdapter = new RecipesAdapter(recipesList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recipesAdapter);

        RecipeApplication application = (RecipeApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        recipesList = Recipe.listAll(Recipe.class);
        showRecipe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = "DownloadedRecipesActivity";
        Log.i("Analytics", name);
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showRecipe()  {
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
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Online")
                        .build());
                Intent intentOnline = new Intent(this, RecipesListActivity.class);
                this.startActivity(intentOnline);
                break;
            case R.id.offline:
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Offline")
                        .build());
                Intent intentOffline = new Intent(this, DownloadedRecipesActivity.class);
                this.startActivity(intentOffline);
                break;
            case R.id.create:
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("Create")
                        .build());
                Intent intentCreate = new Intent(this, UploadRecipeActivity.class);
                this.startActivity(intentCreate);
                break;
            case R.id.about:
                mTracker.send(new HitBuilders.EventBuilder()
                        .setCategory("Action")
                        .setAction("About")
                        .build());
                Intent intentAbout = new Intent(this, AboutActivity.class);
                this.startActivity(intentAbout);
                break;
        }
        return true;
    }
}
