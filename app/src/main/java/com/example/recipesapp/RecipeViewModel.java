package com.example.recipesapp;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RecipeViewModel extends AndroidViewModel {
    private RecipeRepository mRepository;

    private LiveData<List<Recipe>> mAllRecipes;

    public RecipeViewModel (Application application){
        super(application);
        mRepository = new RecipeRepository(application);
        mAllRecipes = mRepository.getAllWords();
    }
    LiveData<List<Recipe>> getAllWords() { return  mAllRecipes;}

    public void insert (Recipe recipe ){ mRepository.insert(recipe);}
}

