package chef.master.masterchef.network.mock;

import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.network.GsonHelper;
import chef.master.masterchef.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;



public class RecipesMock {

    static List<Recipe> recipesList = new ArrayList<>();
    static boolean isInitialised = false;

    public static Recipe testRecipe1 = new Recipe("Steak", "Yummy", "Money");
    public static Recipe testRecipe2 = new Recipe("Steak2", "Yummy2", "Money2");

    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipes") && request.method().equals("GET")) {
            if (!isInitialised) {
                recipesList.add(testRecipe1);
                recipesList.add(testRecipe2);
                isInitialised = true;
            }
            responseString = GsonHelper.getGson().toJson(recipesList);
            responseCode = 200;
        }else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "recipe/1") && request.method().equals("GET")) {
            responseString = GsonHelper.getGson().toJson(testRecipe1);
            responseCode = 200;
        } else if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "add") && request.method().equals("POST")) {
            recipesList.add(new Recipe("test", "test", "test"));
            responseString = "";
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return MockHelper.makeResponse(request, headers, responseCode, responseString);
    }

    public static void resetList() {
        recipesList.clear();
        isInitialised = false;
    }
}
