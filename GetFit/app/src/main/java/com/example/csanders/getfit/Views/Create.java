package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.Calendar;
import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Create extends Activity {
    private RadioButton meal;
    private RadioButton workout;
    private EditText Name;
    private EditText Servings;
    private EditText Calories;
    private EditText Recommended;
    private EditText instructions;
    private EditText length;
    private EditText MealType;
    private EditText workouttype;
    private Button addItem;
    private MultiAutoCompleteTextView options;
    String[] COUNTRIES = new String[5];
    Calendar calendar = Calendar.getInstance();
    int ID;

    DBHandler db = new DBHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Bundle bundle = getIntent().getExtras();
        String use = bundle.getString("ID");
        ID = Integer.parseInt(use);
        meal = (RadioButton)findViewById(R.id.mealSelection);
        workout = (RadioButton)findViewById(R.id.workoutSelection);
        Name = (EditText)findViewById(R.id.Name);
        Servings = (EditText)findViewById(R.id.Servings);
        Calories = (EditText)findViewById(R.id.Calories);
        Recommended = (EditText)findViewById(R.id.recommended);
        instructions = (EditText)findViewById(R.id.instructions);
        length = (EditText)findViewById(R.id.length);
        workouttype = (EditText)findViewById(R.id.workouttype);
        MealType = (EditText)findViewById(R.id.mealtype);
        addItem = (Button)findViewById(R.id.addItemToDB);
        options = (MultiAutoCompleteTextView)findViewById(R.id.multiAutoCompleteTextView);

        COUNTRIES = new String[] {
                "Belgium", "France", "Italy", "Germany", "Spain"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        options.setAdapter(adapter);
        options.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());



        meal.setChecked(true);



        //List<Ingredients> ing = db.getAllIngredients();

//        db.addIngredients(new Ingredients(1, "Banana", 89, "Fruit"));
//        db.addIngredients(new Ingredients(2, "Apple", 52, "Fruit"));
//        db.addIngredients(new Ingredients(3, "Strawberry", 33, "Fruit"));
//        db.addIngredients(new Ingredients(4, "Orange", 47, "Fruit"));
//        db.addIngredients(new Ingredients(5, "Mango", 60, "Fruit"));
//
//        db.addIngredients(new Ingredients(6, "Lettuce", 15, "Vegetable"));
//        db.addIngredients(new Ingredients(7, "Green Pepper", 20, "Vegetable"));
//        db.addIngredients(new Ingredients(8, "Onion", 40, "Vegetable"));
//        db.addIngredients(new Ingredients(9, "Carrot", 41, "Vegetable"));
//        db.addIngredients(new Ingredients(10, "Rutabaga", 38, "Vegetable"));
//
//        db.addIngredients(new Ingredients(11, "4oz Chicken Breast (No Skin, raw)", 124, "Protein"));
//        db.addIngredients(new Ingredients(12, "4.1oz Chicken Thigh (No Skin, raw)", 82, "Protein"));
//        db.addIngredients(new Ingredients(13, "4oz Chicken Breast (With Skin, raw)", 194, "Protein"));
//        db.addIngredients(new Ingredients(14, "4oz Beef Sirloin Steak (raw)", 227, "Protein"));
//        db.addIngredients(new Ingredients(15, "4oz Pork Chop (raw)", 132, "Protein"));
//        db.addIngredients(new Ingredients(16, "0.3oz Medium Slice Bacon", 46, "Protein"));
//
//        db.addIngredients(new Ingredients(17, "1.0oz Panko Breadcrumbs", 110, "Seasoning"));
//        db.addIngredients(new Ingredients(18, "1.0oz Shredded Mozzarella Cheese", 80, "Dairy"));
//        db.addIngredients(new Ingredients(19, "1.0oz Grated Parmesan Cheese", 122, "Dairy"));
//        db.addIngredients(new Ingredients(20, "1.0oz Canned Tomato Sauce", 7, "Seasoning"));
//
//        for(Ingredients ingredients : ing){
//            Log.i("Categories: ", ingredients.getCategory());
//            Log.i("Name: ", ingredients.getIngredientName());
//            Log.i("Calories: ", Integer.toString(ingredients.getCalories()));
//            Log.i("ID: ", Integer.toString(ingredients.getIngredientId()));
//            Log.i("User ID: ", Integer.toString(ingredients.getIngredient_userid()));
//        }
  }


    public void onMealRadioButtonClicked(View view) {
        Calories.setHint("Calories Gained");
        options.setHint("Ingredients");

        Servings.setVisibility(View.VISIBLE);
        Recommended.setVisibility(View.VISIBLE);
        instructions.setVisibility(View.VISIBLE);
        MealType.setVisibility(View.VISIBLE);


        length.setVisibility(View.INVISIBLE);
        workouttype.setVisibility(View.INVISIBLE);


        workout.setChecked(false);


    }


    public void onWorkoutRadioButtonClicked(View view) {

        Calories.setHint("Calories Burned");
        options.setHint("Equipment");
        Servings.setVisibility(View.INVISIBLE);
        Recommended.setVisibility(View.INVISIBLE);
//        instructions.setVisibility(View.INVISIBLE);
        MealType.setVisibility(View.INVISIBLE);

        length.setVisibility(View.VISIBLE);
        workouttype.setVisibility(View.VISIBLE);


        length.setHint("Length");
        workouttype.setHint("Workout Type");

        meal.setChecked(false);


    }


    public void AddtoDatabase(View view) {

        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        String publicationDate = "" + month + "/" + day + "/" + year;

        if(meal.isChecked() == false) {


            String InputWorkoutName = Name.getText().toString();
            String InputWorkoutCalories = Calories.getText().toString();
            int WorkoutCalories = Integer.parseInt(InputWorkoutCalories);
            String InputWorkoutEquipment = options.getText().toString();
            String InputWorkoutType = workouttype.getText().toString();
            String InputWorkoutLength = length.getText().toString();
            String WorkoutInstructions = instructions.getText().toString();
            int workoutLength = Integer.parseInt(InputWorkoutLength);
            int workouts_user_id = ID;

            db.addWorkouts(new Workouts(InputWorkoutName,InputWorkoutType,InputWorkoutEquipment,workoutLength,WorkoutCalories, publicationDate, WorkoutInstructions, workouts_user_id));

            Bundle bundle = new Bundle();
            bundle.putString("ID", String.valueOf(ID));
            Intent library = new Intent(this, Library.class);
            library.putExtras(bundle);
            startActivity(library);

             Toast.makeText(getApplicationContext(), "Added Workout!", Toast.LENGTH_LONG).show();

        }
        if(workout.isChecked() == false) {

            String InputMealName = Name.getText().toString();
            String InputCaloriesGained = Calories.getText().toString();
            int CaloriesGained = Integer.parseInt(InputCaloriesGained);
            String InputIngredients  = options.getText().toString();
            String InputServings = Servings.getText().toString();
            int MealServings = Integer.parseInt(InputServings);
            String InputRecommendedFor = Recommended.getText().toString();
            String Dietary = "None";
            String MealInstructions = instructions.getText().toString();
            String InputMealType = MealType.getText().toString();
            int meal_user_id = ID;

            db.addMeals(new Meals(InputMealName, CaloriesGained, MealServings, publicationDate, InputMealType, InputRecommendedFor, MealInstructions, Dietary, meal_user_id, InputIngredients));

            Bundle bundle = new Bundle();
            bundle.putString("ID", String.valueOf(ID));
            Intent library = new Intent(this, Library.class);
            library.putExtras(bundle);
            startActivity(library);

            Toast.makeText(getApplicationContext(), "Added Meal!", Toast.LENGTH_LONG).show();

        }
    }
}
