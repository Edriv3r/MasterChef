package chef.master.masterchef.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

import javax.inject.Inject;

import chef.master.masterchef.R;
import chef.master.masterchef.RecipeApplication;
import chef.master.masterchef.presenter.RecipesListPresenter;

public class RecipeDetailActivity extends AppCompatActivity implements RecipeView{
    private ImageView recipeImage;
    private TextView recipeName;
    private TextView recipeDirections;
    private TextView recipeIngredients;


    private Tracker mTracker;

    @Inject
    RecipesListPresenter detailPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);
        recipeImage = (ImageView)findViewById(R.id.ivDetailRecipeImage);
        recipeName = (TextView)findViewById(R.id.tvDetailRecipeName);
        recipeDirections = (TextView)findViewById(R.id.tvDetailRecipeDirections);
        recipeIngredients = (TextView)findViewById(R.id.tvDetailRecipeIngredients);

        RecipeApplication application = (RecipeApplication) getApplication();
        mTracker = application.getDefaultTracker();
    }

    @Override
    protected void onStart() {
        super.onStart();
        showRecipe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        String name = "RecipesDetailActivity";
        Log.i("Analytics", name);
        mTracker.setScreenName(name);
        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showRecipe() {
        Intent intent = getIntent();
        recipeName.setText(intent.getStringExtra("recipeName"));
        recipeDirections.setText(intent.getStringExtra("recipeDirections"));
        recipeIngredients.setText(intent.getStringExtra("recipeIngredients"));
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
