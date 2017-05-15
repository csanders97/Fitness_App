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

import com.example.csanders.getfit.Models.Users;

import java.util.ArrayList;
import java.util.List;

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

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Meals);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Ingredients);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Workouts);

        // Creating tables again
        onCreate(db);

    }

    // Adding new shop
    public void addUser(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FirstName, users.getFirstName()); // User FirstName
        values.put(KEY_LastName, users.getLastName()); // User LastName
        values.put(KEY_Weight, users.getWeight()); // User Weight
        values.put(KEY_Height, users.getHeight()); // User Height


     // Inserting data into Users Table
        db.insert(TABLE_Users, null, values);
        db.close();
    }
    // Getting one shop
    public Users getUser(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_UserID,
                KEY_FirstName, KEY_LastName, KEY_Weight, KEY_Height}, KEY_UserID + "=?",
        new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Users info = new Users(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
// return shop
        return info;
    }
    // Getting All Users
    public List<Users> getAllShops() {
        List<Users>  listofusers = new ArrayList<Users>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_Users;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Users users = new Users();
                users.setUserId(Integer.parseInt(cursor.getString(0)));
                users.setFirstName(cursor.getString(1));
                users.setLastName(cursor.getString(2));
                users.setWeight(cursor.getInt(3));
                users.setHeight(cursor.getInt(4));
// Adding contact to list
                listofusers.add(users);
            } while (cursor.moveToNext());
        }

// return contact list
        return listofusers;
    }
    // Updating a shop
    public int updateUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_FirstName, user.getFirstName()); // User FirstName
        values.put(KEY_LastName, user.getLastName()); // User LastName
        values.put(KEY_Weight, user.getWeight()); // User Weight
        values.put(KEY_Height, user.getHeight()); // User Height


// updating row
        return db.update(TABLE_Users, values, KEY_UserID + " = ?",
        new String[]{String.valueOf(user.getUserId())});
    }

    // Deleting a shop
    public void deleteShop(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_UserID + " = ?",
        new String[] { String.valueOf(user.getUserId()) });
        db.close();
    }



}
