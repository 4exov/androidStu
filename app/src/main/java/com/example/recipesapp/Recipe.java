package com.example.recipesapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Blob;

@Entity(tableName = "recipe_table")
public class Recipe {
    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    @PrimaryKey(autoGenerate = true)
    private int recipeId;

    @NonNull
    @ColumnInfo(name ="recipe")
    public String mName;
    @NonNull
    @ColumnInfo(name="ingredients")
    public String mIngredients;
    @NonNull
    @ColumnInfo(name = "method")
    public String mMethod;
    @Ignore
    @ColumnInfo( name = "image")
    public Blob mImage;


    public String getmName() {
        return mName;
    }


    public String getmIngredients() {
        return mIngredients;
    }


    public String getmMethod() {
        return mMethod;
    }


    public Blob getmImage() {
        return mImage;
    }

    public Recipe(){



    }
    public String getRecipe(){return this.mName;}
}



