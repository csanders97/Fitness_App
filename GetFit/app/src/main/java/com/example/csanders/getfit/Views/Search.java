package com.example.csanders.getfit.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.R;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sophie on 5/15/2017.
 */

public class Search extends Activity {
    private TextView name;
    private ListView listofMeal;
    private RadioButton MealSearch;
    private RadioButton WorkoutSearch;
    private AutoCompleteTextView search;
    public static ArrayList<String> mealsearch = new ArrayList<String>();
    public static ArrayList<String> workoutsearch = new ArrayList<String>();
    Meals meals = new Meals();
    public final static int quota = 1000;

    List<Meals> meal;
    //String[] mealArray;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        final DBHandler db = new DBHandler(this);
        db.getAllMeals();
        MealSearch = (RadioButton) findViewById(R.id.mealRadioBtnSearch);
        WorkoutSearch = (RadioButton)findViewById(R.id.workoutRadioBtnSearch);
        listofMeal = (ListView)findViewById(R.id.listOfMeals);
        search = (AutoCompleteTextView)findViewById(R.id.SearchTextView);





        search.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                //Toast.makeText(getApplicationContext(), "Registration Successful!", Toast.LENGTH_LONG).show();

            }
        });


        listofMeal.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String record = ((TextView)view).getText().toString();
                String[] name = record.split("\\s+");
                String itemName = name[0];
                List<Workouts> workout = db.getAllWorkouts();
                for(Workouts workouts : workout) {
                    if (workouts.getWorkoutName().equals(itemName)) {
                        int workoutId = workouts.getWorkoutId();
                        Bundle bundle = new Bundle();
                        bundle.putString("Workout", String.valueOf(workoutId));
                        Intent item = new Intent(view.getContext(), Item.class);
                        item.putExtras(bundle);
                        startActivity(item);
                    }
                }
                List<Meals> meal = db.getAllMeals();
                for(Meals meals : meal) {
                    if (meals.getMealName().equals(itemName)) {
                        int mealId = meals.getMealId();
                        Bundle bundle = new Bundle();
                        bundle.putString("Meal", String.valueOf(mealId));
                        Intent item = new Intent(view.getContext(), Item.class);
                        item.putExtras(bundle);
                        startActivity(item);
                    }
                }
            }
        });


       // mealArray =  new String[meal.size()];
//
//        db.addMeals(new Meals(1, "Burrito", 500, 3, "publication", "NAN", "recommendations", "No Restrictions", "eat the burrito"));
//        db.addMeals(new Meals(2, "Steak Dinner", 1001, 5, "publication", "NAN", "recommendations", "No Restrictions", "eat the Steak"));
          //db.addMeals(new Meals(3, "CheeseBurger", 800, 3, "publication", "NAN", "recommendations", "Meat Lover", " eat the Cheeseburger"));
//
//          db.addWorkouts(new Workouts(1, "Running" , "Cardio", 10));
//          db.addWorkouts(new Workouts(2, "Jogging" , "Cardio", 10));

        //quotaMealSearch();
    }




    public void searchOnClick(View view) {

    }


    public void MealSearchClick(View view) {

         ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mealsearch);
         listofMeal.setAdapter(adapter);
         search.setAdapter(adapter);


         WorkoutSearch.setChecked(false);



    }

    public void WorkoutSearchClick(View view) {

        ArrayAdapter<String> wadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,workoutsearch);
        listofMeal.setAdapter(wadapter);
        search.setAdapter(wadapter);


        MealSearch.setChecked(false);

    }

    public void mealDisplay(int index){
//        name = (TextView) findViewById(R.id.mealName);
//        name.setText(String.valueOf(mealArray[index]), TextView.BufferType.EDITABLE);
//        Log.i("Test3: ", mealArray[index]);
//    }
//
//    public void quotaMealSearch()
//    {
//        //String item = ingredient.getQuery().toString();
//
//        for(int i = 0; i < meal.size(); i++){
//            mealArray[i] = meal.get(i).getMealName();
//            if(meals.getMealCalories() <= quota){
//                if(mealArray[i] == null){
//                    Log.i("Null", "Value");
//                }else{
//                    //searchMealByIngredients(i);
//                    mealDisplay(i);
//                }
//            }
//        }
//    }
//
//
//    public void searchMealByIngredients(int index)
//    {
//        String item = ingredient.getQuery().toString();
//
//        if(item == meal.get(index).getMeals_IngredientName() || item == meal.get(index).getDietaryRestrictions() || item == meal.get(index).getRecommendations() || item == meal.get(index).getMealName()){
//            mealDisplay(index);
//        }
  }

}
