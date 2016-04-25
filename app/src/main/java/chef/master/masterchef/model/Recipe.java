package chef.master.masterchef.model;

import android.content.ReceiverCallNotAllowedException;
import android.media.Image;

import com.orm.SugarRecord;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class Recipe extends SugarRecord {
    protected String title;
    protected String description;
    protected String ingredients;
    protected String directions;
    protected Image image;

    public Recipe() {

    }

    public Recipe(String title, String description, String ingredients, String directions)
    {
        this.title = title;
        this.description = description;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDirections() {
        return directions;
    }

    public String getIngredients() { return ingredients; }
}
