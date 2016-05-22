package chef.master.masterchef.model;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Ra's Al Ghul on 2016. 04. 17..
 */
public class Recipe extends SugarRecord {
    @SerializedName("recipe_id")
    private BigDecimal recipeId = null;
    @SerializedName("name")
    private String name = null;
    @SerializedName("ingredients")
    private String ingredients = null;
    @SerializedName("directions")
    private String directions = null;
    @SerializedName("imageUrl")
    private String imageUrl = null;
    @SerializedName("image")
    private Bitmap image = null;

    public Recipe(){}

    public Recipe(String name, String ingredients, String directions)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public Recipe(String name, String ingredients, String directions, Bitmap image)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
        this.image = image;
    }

    public Recipe(String name, String ingredients, String directions, String imageUrl)
    {
        this.name = name;
        this.ingredients = ingredients;
        this.directions = directions;
        this.imageUrl = imageUrl;
    }

    /**
     * Unique identifier representing a specific recipe.
     **/
    public BigDecimal getRecipeId() {
        return recipeId;
    }
    public void setRecipeId(BigDecimal recipeId) {
        this.recipeId = recipeId;
    }


    /**
     * Name of the recipe.
     **/
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Ingredients of the recipe.
     **/
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }


    /**
     * Directions of the recipe.
     **/
    public String getDirections() {
        return directions;
    }
    public void setDirections(String directions) {
        this.directions = directions;
    }


    /**
     * Image URL representing the recipe.
     **/
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeId, recipe.recipeId) &&
                Objects.equals(name, recipe.name) &&
                Objects.equals(ingredients, recipe.ingredients) &&
                Objects.equals(directions, recipe.directions) &&
                Objects.equals(image, recipe.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, name, ingredients, directions, image);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recipe {\n");

        sb.append("    recipeId: ").append(toIndentedString(recipeId)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
        sb.append("    directions: ").append(toIndentedString(directions)).append("\n");
        sb.append("    image: ").append(toIndentedString(imageUrl)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}