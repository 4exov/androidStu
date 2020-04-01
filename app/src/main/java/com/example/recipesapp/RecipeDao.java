package com.example.recipesapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface RecipeDao {


    // allowing the insert of the same word multiple times by passing a
    // conflict resolution strategy
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Recipe recipe);

    @Query("DELETE FROM recipe_table")
    void deleteAll();

    @Query("SELECT * from recipe_table ORDER BY recipe ASC")
    LiveData<List<Recipe>> getAlphabetizedWords();
}