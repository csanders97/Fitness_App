package com.example.csanders.getfit.Tables;

/**
 * Created by Matthew Balderas on 5/13/2017.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 11;

    // Database Name
    private static final String DATABASE_NAME = "Fitness";

    // Table Names
    private static final String TABLE_Ingredients = "Ingredients";
    private static final String TABLE_Meals = "Meals";
    private static final String TABLE_Users = "Users";
    private static final String TABLE_Workouts = "Workouts";


    // Users Table - column names
    private static final String KEY_UserID = "user_id";
    private static final String KEY_Password = "password";
    private static final String KEY_UserName = "first_name";
    private static final String KEY_AGE = "age";
    private static final String KEY_Weight = "weight";
    private static final String KEY_Height = "height";
    private static final String KEY_Goal = "goal";
    private static final String KEY_CalorieQuota = "calorie_quota";


    // Ingredients Table - column nmaes
    private static final String KEY_IngredientId = " ingredient_id ";
    private static final String KEY_IngredientName = " ingredient_name ";
    private static final String KEY_IngredientCalories = " calories ";
    private static final String KEY_IngredientCategory = " category ";
    //Foreign Key
    private static final String KEY_Ingredient_UserID = " userId ";



    // Meals - column names
    private static final String KEY_MealId = " meal_id ";
    private static final String KEY_MealName = " meal_name ";
    private static final String KEY_MealCalories = " meal_calories ";
    private static final String KEY_Servings = " servings ";
    private static final String KEY_Publications = " publications ";
    private static final String KEY_MealType = " meal_type ";
    private static final String KEY_Recommendations = " recommendations ";
    private static final String KEY_DietaryRestrictions = " dietary_restrictions ";
    //Foreign Key
    private static final String KEY_Meals_UserID = " userId ";
    private static final String KEY_Meals_IngredientName = " ingredient_name ";


    // Workouts Table - column names
    private static final String KEY_WorkoutId= " workout_id ";
    private static final String KEY_WorkoutName = " workout_name ";
    private static final String KEY_WorkoutType = " workout_type ";
    private static final String KEY_Equipment = " equipment ";
    private static final String KEY_WorkoutLength = " workout_length ";
    private static final String KEY_CaloriesBurned = " burned_calories";
    //Foreign Key
    private static final String KEY_Workout_User_ID = "userId";


    // Creating tables
    // User table
    private static final String CREATE_TABLE_USERS =
            "CREATE TABLE " + TABLE_Users +
                    "(" + KEY_UserID + " INTEGER PRIMARY KEY,"
                    + KEY_Password + " TEXT, "
                    + KEY_UserName + " TEXT,"
                    + KEY_AGE  + " INTEGER,"
                    + KEY_Weight + " INTEGER,"
                    + KEY_Height + " REAL,"
                    + KEY_Goal   +  " TEXT,"
                    + KEY_CalorieQuota + " Real" +")";

    // Ingredients table
    private static final String CREATE_TABLE_INGREDIENTS =
            "CREATE TABLE " + TABLE_Ingredients +
                    "(" + KEY_IngredientId + " INTEGER PRIMARY KEY,"
                    + KEY_IngredientName + " TEXT,"
                    + KEY_IngredientCalories + " INTEGER, "
                    + KEY_IngredientCategory + " TEXT,"
                    + KEY_Ingredient_UserID + " INTEGER,"
                    + "FOREIGN KEY (" + KEY_Ingredient_UserID + ") REFERENCES " + TABLE_Users + "(" + KEY_UserID + ")" + ")";

    // Meals table
    private static final String CREATE_TABLE_MEALS=
            "CREATE TABLE " + TABLE_Meals +
                    "(" + KEY_MealId + " INTEGER PRIMARY KEY,"
                    + KEY_MealName + " INTEGER,"
                    + KEY_MealCalories + " INTEGER,"
                    + KEY_Servings + " INTEGER,"
                    + KEY_Publications + " TEXT,"
                    + KEY_MealType + " TEXT,"
                    + KEY_Recommendations + " TEXT,"
                    + KEY_DietaryRestrictions + "TEXT, "
                    + KEY_Meals_UserID + " INTEGER, "
                    + KEY_Meals_IngredientName + " TEXT,"
                    + "FOREIGN KEY (" + KEY_Meals_UserID + ") REFERENCES " + TABLE_Users + "(" + KEY_UserID + "),"
                    + "FOREIGN KEY (" + KEY_Meals_IngredientName + " ) REFERENCES " + TABLE_Ingredients + "(" + KEY_IngredientName + ")"  + ")";



    // Workouts table
    private static final String CREATE_TABLE_WORKOUTS =
            "CREATE TABLE " + TABLE_Workouts +
                    "(" + KEY_WorkoutId   + " INTEGER PRIMARY KEY,"
                    + KEY_WorkoutName     + " TEXT,"
                    + KEY_WorkoutType     + " TEXT,"
                    + KEY_WorkoutLength   + " INTEGER,"
                    + KEY_Equipment       + " TEXT,"
                    + KEY_CaloriesBurned  + " INTEGER,"
                    + KEY_Workout_User_ID + " INTEGER,"
                    + "FOREIGN KEY (" + KEY_Workout_User_ID + ") REFERENCES " + TABLE_Users + "(" + KEY_UserID + ")"  + ")";

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

    // Adding new User
    public void addUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_UserName, users.getUserName()); // User Username
        values.put(KEY_Password, users.getPassword()); //User Password
        values.put(KEY_Weight, users.getWeight()); // User Weight
        values.put(KEY_Height, users.getHeight()); // User Height
        values.put(KEY_Goal, users.getGoal()); // User Goal
        values.put(KEY_CalorieQuota, users.getCaloriequota()); //User CalorieQuota

        // Inserting data into Users Table
        db.insert(TABLE_Users, null, values);
        db.close();
    }

    // Getting one User
    public Users getUsers(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_Users, new String[]{KEY_UserID,
                        KEY_UserName, KEY_Password, KEY_AGE, KEY_Weight, KEY_Height, KEY_Goal, KEY_CalorieQuota}, KEY_UserID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Users info = new Users(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getInt(3), cursor.getInt(4), cursor.getDouble(5), cursor.getString(6), cursor.getDouble(7));
// return User
        return info;
    }
    // Getting All Users
    public List<Users> getAllUsers() {
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
                users.setPassword(cursor.getString(1));
                users.setUserName(cursor.getString(2));
                users.setAge(cursor.getInt(3));
                users.setWeight(cursor.getInt(4));
                users.setHeight(cursor.getInt(5));
                users.setGoal(cursor.getString(6));
                users.setCaloriequota(cursor.getDouble(7));

// Adding contact to list
                listofusers.add(users);
            } while (cursor.moveToNext());
        }

// return contact list
        return listofusers;
    }
    // Updating a User
    public int updateUser(int ID, String name, int age, int weight, Double height, String goal, double quota) {
        SQLiteDatabase db = this.getWritableDatabase();
        Users users = getUsers(ID);
        users.setUserName(name);
        users.setAge(age);
        users.setWeight(weight);
        users.setHeight(height);
        users.setGoal(goal);
        users.setCaloriequota(quota);
        ContentValues values = new ContentValues();
        values.put(KEY_UserName, users.getUserName()); // User UserName
        values.put(KEY_Password, users.getPassword()); //User Password
        values.put(KEY_AGE, users.getAge()); //User Age
        values.put(KEY_Weight, users.getWeight()); // User Weight
        values.put(KEY_Height, users.getHeight()); // User Height
        values.put(KEY_Goal, users.getGoal()); //User Goal
        values.put(KEY_CalorieQuota, users.getCaloriequota()); //User Calorie Quota

// updating row
        return db.update(TABLE_Users, values, KEY_UserID + " = ?",
                new String[]{String.valueOf(users.getUserId())});
    }

    // Deleting a User
    public void deleteUsers(Users users) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Users, KEY_UserID + " = ?",
                new String[] { String.valueOf(users.getUserId())});
        db.close();
    }

    //----------------Ingredients---------------------
    //Adding an Ingredient

    public void addIngredients(Ingredients ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IngredientName, ingredients.getIngredientName()); // Ingredient Name
        values.put(KEY_IngredientCalories, ingredients.getCalories()); // Ingredient Calories
        values.put(KEY_IngredientCategory, ingredients.getCategory()); // Ingredient Category
        values.put(KEY_Ingredient_UserID, ingredients.getIngredient_userid()); // Ingredient_User_ID



        // Inserting data into Ingredients Table
        db.insert(TABLE_Ingredients, null, values);
        db.close();
    }



    //Get all Ingredients
    public List<Ingredients> getAllIngredients() {
        List<Ingredients>  listofingredients = new ArrayList<Ingredients>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_Ingredients;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Ingredients ints = new Ingredients();
                ints.setIngredientId(Integer.parseInt(cursor.getString(0)));
                ints.setIngredientName(cursor.getString(1));
                ints.setCalories(cursor.getInt(2));
                ints.setCategory(cursor.getString(3));
                ints.setIngredient_userid(cursor.getInt(4));
// Adding contact to list
                listofingredients.add(ints);
            } while (cursor.moveToNext());
        }

// return contact list
        return listofingredients;
    }



    //Updating an Ingredient
    public int updateIngredient(Ingredients ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_IngredientName, ingredients.getIngredientName()); // Ingredient Name
        values.put(KEY_IngredientCalories, ingredients.getCalories()); // Ingredient Calories
        values.put(KEY_IngredientCategory, ingredients.getCategory()); // Ingredient Category


// updating row
        return db.update(TABLE_Ingredients, values, KEY_IngredientId+ " = ?",
                new String[]{String.valueOf(ingredients.getIngredientId())});
    }


    //Deleting an Ingredient
    public void deleteIngredients(Ingredients ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Ingredients, KEY_IngredientId + " = ?",
                new String[] { String.valueOf(ingredients.getIngredientId())});
        db.close();
    }




    //-------------------------Meals----------------------
    //Adding a Meal
    public void addMeals(Meals meals) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MealName, meals.getMealName()); // Meal Name
        values.put(KEY_MealCalories, meals.getMealCalories()); // Meal Calories
        values.put(KEY_Servings, meals.getServings()); // Meal Servings
        values.put(KEY_Publications, meals.getPublications()); // Meal Publications
        values.put(KEY_MealType, meals.getMealType()); // Meal Type
        values.put(KEY_DietaryRestrictions, meals.getDietaryRestrictions()); // Meal Dietary Restrictions
        values.put(KEY_Meals_UserID, meals.getMeals_userID()); // Meal_UserID
        values.put(KEY_Meals_IngredientName, meals.getMeals_IngredientName()); // Meal IngredientName


        // Inserting data into Users Table
        db.insert(TABLE_Meals, null, values);
        db.close();
    }


    //Updating a Meal
    public int updateMeal(Meals meal) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_MealName, meal.getMealName()); // Meal Name
        values.put(KEY_MealCalories, meal.getMealCalories()); // Meal Calories
        values.put(KEY_Servings, meal.getServings()); // Meal Servings
        values.put(KEY_Publications, meal.getPublications()); // Meal Publications
        values.put(KEY_MealType, meal.getMealType()); // Meal Type
        values.put(KEY_DietaryRestrictions, meal.getDietaryRestrictions()); // Meal Dietary Restrictions


// updating row
        return db.update(TABLE_Meals, values, KEY_MealId + " = ?",
                new String[]{String.valueOf(meal.getMealId())});
    }



    //Get all Meals
    public List<Meals> getAllMeals() {
        List<Meals>  listofmeals = new ArrayList<Meals>();
// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_Meals;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Meals meals = new Meals();
                meals.setMealId(Integer.parseInt(cursor.getString(0)));
                meals.setMealName(cursor.getString(1));
                meals.setMealCalories(cursor.getInt(2));
                meals.setServings(cursor.getInt(3));
                meals.setPublications(cursor.getString(4));
                meals.setMealType(cursor.getString(5));
                meals.setDietaryRestrictions(cursor.getString(6));
                meals.setMeals_userID(cursor.getInt(7));
                meals.setMeals_IngredientName(cursor.getString(8));

// Adding contact to list
                listofmeals.add(meals);
            } while (cursor.moveToNext());
        }

// return contact list
        return listofmeals;
    }


    //Deleting a Meal
    public void deleteMeals(Meals meals) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Meals, KEY_MealId + " = ?",
                new String[] { String.valueOf(meals.getMealId())});
        db.close();
    }



    //--------------------------Workouts-------------------

    //Adding a workout
    public void addWorkouts(Workouts workout) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_WorkoutName, workout.getWorkoutName()); // Workout Name
        values.put(KEY_WorkoutType, workout.getWorkoutType()); // Workout Type
        values.put(KEY_Equipment, workout.getEquipment()); //Workout Equipment
        values.put(KEY_WorkoutLength, workout.getLength()); // Workout Length
        values.put(KEY_CaloriesBurned, workout.getCaloriesBurned()); //Calories burned after workout
        values.put(KEY_Workout_User_ID, workout.getWorkout_user_id()); // Workout User ID

        // Inserting data into Workouts Table
        db.insert(TABLE_Workouts, null, values);
        db.close();
    }


    //Updating a workout
    public int updateWorkout(Workouts workouts) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_WorkoutName, workouts.getWorkoutName()); // Workout Name
        values.put(KEY_WorkoutType, workouts.getWorkoutType()); // Workout Type
        values.put(KEY_Equipment, workouts.getEquipment());  //Workout Equipment
        values.put(KEY_WorkoutLength, workouts.getLength()); // Workout Length
        values.put(KEY_CaloriesBurned, workouts.getCaloriesBurned()); //Calories burned after workout



// updating row
        return db.update(TABLE_Workouts, values, KEY_WorkoutId + " = ?",
                new String[]{String.valueOf(workouts.getWorkoutId())});
    }



    //Get all Workouts
    public List<Workouts> getAllWorkouts() {
        List<Workouts> listofworkouts = new ArrayList<Workouts>();

// Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_Workouts;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Workouts workouts = new Workouts();
                workouts.setWorkoutId(Integer.parseInt(cursor.getString(0)));
                workouts.setWorkoutName(cursor.getString(1));
                workouts.setWorkoutType(cursor.getString(2));
                workouts.setEquipment(cursor.getString(3));
                workouts.setLength(cursor.getInt(4));
                workouts.setCaloriesBurned(cursor.getInt(5));
                workouts.setWorkout_user_id(cursor.getInt(6));

// Adding workout to list
                listofworkouts.add(workouts);
            } while (cursor.moveToNext());
        }

// return workout list
        return listofworkouts;
    }




    //Deleting a workout
    public void deleteWorkouts(Workouts workouts) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_Workouts, KEY_WorkoutId + " = ?",
                new String[] { String.valueOf(workouts.getWorkoutId())});
        db.close();
    }
}