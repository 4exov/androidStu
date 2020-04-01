package com.example.recipesapp;

import android.app.Application;
import androidx.lifecycle.LiveData;

import java.util.List;

class RecipeRepository {
    private RecipeDao mNameDao;
    private LiveData<List<Recipe>> mAllRecipes;

    RecipeRepository(Application application){
        RecipeRoomDatabase db = RecipeRoomDatabase.getDatabase(application);
        mNameDao = db.recipeDao();
        mAllRecipes = mNameDao.getAlphabetizedWords();

    }
    LiveData<List<Recipe>> getAllWords(){
        return mAllRecipes;
    }
    void insert (Recipe recipe){
        RecipeRoomDatabase.databaseWriteExecutor.execute(() -> {
            mNameDao.insert(recipe);
        });
    }

}
