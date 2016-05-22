package chef.master.masterchef.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chef.master.masterchef.R;
import chef.master.masterchef.model.Recipe;
import chef.master.masterchef.view.RecipeDetailActivity;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.MyViewHolder> {

    private List<Recipe> recipesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.tvRecipeName);
        }
    }


    public RecipesAdapter(List<Recipe> recipesList) {
        this.recipesList = recipesList;
        notifyDataSetChanged();
    }

    public void setList(List<Recipe> recipesList) {
        this.recipesList = recipesList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Recipe recipe = recipesList.get(position);
        holder.name.setText(recipe.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Recipe r = Recipe.findById(Recipe.class, position);
                Intent intent = new Intent(v.getContext(), RecipeDetailActivity.class);
                intent.putExtra("recipeName", recipe.getName());
                intent.putExtra("recipeDirections", recipe.getDirections());
                intent.putExtra("recipeImageUrl", recipe.getImageUrl());
                intent.putExtra("recipeIngredients", recipe.getIngredients());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return recipesList.size();
    }
}
