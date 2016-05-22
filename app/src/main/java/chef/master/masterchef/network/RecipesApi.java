package chef.master.masterchef.network;

import chef.master.masterchef.model.Recipe;
import retrofit2.Call;
import retrofit2.http.*;

import java.math.BigDecimal;
import java.util.List;

public interface RecipesApi {
  
  /**
   * Add a recipe
   * This endpoint adds the recipe to the database.
   * @return Call<Boolean>
   */
  
  @POST("add")
  Call<Boolean> addPost();
  
  /**
   * Get one recipe
   * This endpoint returns information of the desired recipe, selected with id.
   * @param id ID of the recipe
   * @return Call<Void>
   */
  
  @GET("recipe/{id}")
  Call<Void> recipeIdGet(
    @Path("id") BigDecimal id
  );
  
  /**
   * Get all recipes
   * The Recipes endpoint returns information about the available recipes. The response includes the recipe name, \nneeded ingredients, directions and the image url.
   * @return Call<List<Recipe>>
   */
  
  @GET("recipes")
  Call<List<Recipe>> recipesGet();
}
