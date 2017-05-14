package com.example.csanders.getfit.Tables;

/**
 * Created by Matthew Balderas on 5/13/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends  SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Fitness";

    // Table Names
    private static final String TABLE_Ingredients = "Ingredients";
    private static final String TABLE_Meals = "Meals";
    private static final String TABLE_Users = "Users";
    private static final String TABLE_Workouts = "Workouts";


    // Users Table - column names
    private static final String KEY_UserID = "user_id";
    private static final String KEY_FirstName = "first_name";
    private static final String KEY_LastName = "last_name";
    private static final String KEY_Weight = "weight";
    private static final String KEY_Height = "height";


    // Ingredients Table - column nmaes
    private static final String KEY_IngredientId = "ingredient_id";
    private static final String KEY_IngredientName = "ingredient_name";
    private static final String KEY_IngredientCalories = "calories";
    private static final String KEY_IngredientCategory = "category";

    // Meals - column names
    private static final String KEY_MealId = "meal_id";
    private static final String KEY_MealName = "meal_name";
    private static final String KEY_MealCalories = "meal_calories";
    private static final String KEY_Servings = "servings";
    private static final String KEY_Publications = "publications";
    private static final String KEY_MealType = "meal_type";
    private static final String KEY_Recommendations = "recommendations";
    private static final String KEY_DietaryRestrictions = "dietary_restrictions";


    // Workouts Table - column names
    private static final String KEY_WorkoutId= "workout_id";
    private static final String KEY_WorkoutName = "workout_name";
    private static final String KEY_WorkoutType = "workout_type";
    private static final String KEY_WorkoutLength = "workout_length";

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
