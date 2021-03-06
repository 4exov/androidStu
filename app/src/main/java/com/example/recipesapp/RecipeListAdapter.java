package com.example.recipesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {

    class RecipeViewHolder extends RecyclerView.ViewHolder{
        private final TextView recipeItemView;

        private RecipeViewHolder(View itemView){
            super(itemView);
            recipeItemView = itemView.findViewById(R.id.textView);
        }
    }
    private final LayoutInflater mInflater;
    private List<Recipe> mRecipes;//cope of recipes name
    RecipeListAdapter(Context context) { mInflater = LayoutInflater.from(context);}

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new RecipeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {
        if (mRecipes != null) {
            Recipe current = mRecipes.get(position);
            holder.recipeItemView.setText(current.getRecipe());
        } else {
            // Covers the case of data not being ready yet.
            holder.recipeItemView.setText("No Recipes");
        }
    }

    void setRecipes(List<Recipe> recipes){
        mRecipes = recipes;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mRecipes != null)
            return mRecipes.size();
        else return 0;
    }
}
