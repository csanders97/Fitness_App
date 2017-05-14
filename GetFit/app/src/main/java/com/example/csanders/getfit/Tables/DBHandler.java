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


    // Creating tables
    // User table
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_Users +
                    "(" + KEY_UserID + " INTEGER PRIMARY KEY,"
                        + KEY_FirstName + " TEXT,"
                        + KEY_LastName + " TEXT,"
                        + KEY_Weight + " INTEGER,"
                        + KEY_Height + " REAL" + ")";

    // Ingredients table
    private static final String CREATE_TABLE_INGREDIENTS =
            "CREATE TABLE " + TABLE_Ingredients +
                        "(" + KEY_IngredientId + " INTEGER PRIMARY KEY,"
                            + KEY_IngredientName + " TEXT,"
                            + KEY_IngredientCalories + " INTEGER,"
                            + KEY_IngredientCategory + " TEXT" + ")";

    // Meals table
    private static final String CREATE_TABLE_MEALS=
            "CREATE TABLE " + TABLE_Meals +
                        "(" + KEY_MealId + " INTEGER PRIMARY KEY,"
                            + KEY_MealName + " INTEGER,"
                            + KEY_MealCalories + " INTEGER,"
                            + KEY_Servings + " DATETIME,"
                            + KEY_Publications + " TEXT,"
                            + KEY_MealType + " TEXT,"
                            + KEY_Recommendations + " TEXT,"
                            + KEY_DietaryRestrictions + "TEXT" + ")";



    // Workouts table
    private static final String CREATE_TABLE_WORKOUTS =
            "CREATE TABLE " + TABLE_Workouts +
                        "(" + KEY_WorkoutId + " INTEGER PRIMARY KEY,"
                            + KEY_WorkoutName + " TEXT,"
                            + KEY_WorkoutType + " TEXT,"
                            + KEY_WorkoutLength + " INTEGER" + ")";

    public DBHandler(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_USERS);
        db.execSQL(CREATE_TABLE_INGREDIENTS);
        db.execSQL(CREATE_TABLE_MEALS);
        db.execSQL(CREATE_TABLE_WORKOUTS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
