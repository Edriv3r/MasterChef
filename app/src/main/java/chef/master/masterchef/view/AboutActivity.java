package chef.master.masterchef.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import javax.inject.Inject;

import chef.master.masterchef.R;
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
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void showAbout() {

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
