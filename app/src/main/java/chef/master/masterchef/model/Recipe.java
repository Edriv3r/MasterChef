package chef.master.masterchef.model;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class Recipe {
    protected String title;
    protected String description;
    protected String ingredients;
    protected String directions;

    Recipe()
    {
        title = "Steak";
        description = "Yummy";
        ingredients = "Money";
        directions = "Order";
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

    public String getIngredients() {
        return ingredients;
    }
}
