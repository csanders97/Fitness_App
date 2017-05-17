package com.example.csanders.getfit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.Tables.DBHandler;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        DBHandler db = new DBHandler(this);

// Inserting Shop/Rows
        Log.d("Insert: ", "Inserting ..");
        db.addUsers(new Users("Billy", "Bob", 300 , 6));
        db.addIngredients(new Ingredients(1,"Carrot",10,"Vegatable",1));
        db.addMeals(new Meals(1,"Salad",190,1,"5-17-2017","Lunch" ," ", " Weight Loss", 1, "Lettuce"));
        db.addWorkouts(new Workouts(1,"Treadmill" , "Cardio", 30,1));




// Reading all shops
        Log.d("Reading: ", "Reading all users..");
        List<Users> users = db.getAllUsers();
        List<Workouts> workoutses = db.getAllWorkouts();
        List<Ingredients> ingredientses = db.getAllIngredients();
        List<Meals> mealses = db.getAllMeals();

        for (Users user : users) {
            String log = "Id: " + user.getUserId() + ",FirstName: " + user.getFirstName() + ",LastName: " + user.getLastName() + ",Weight: " + user.getWeight() + ",Height: " + user.getHeight();
// Writing shops to log
            Log.d("Users: : ", log);
        }

        for (Workouts workout : workoutses) {
            String log = "Id: " + workout.getWorkoutId() + ",Workout: " + workout.getWorkoutName() + ",WorkoutType: " + workout.getWorkoutType() + ",Length: " + workout.getLength() + ", User id: " + workout.getWorkout_user_id();
// Writing shops to log
            Log.d("Workouts: : ", log);
        }

        for (Ingredients ingredients : ingredientses) {
            String log = "Id: " + ingredients.getIngredientId() + ",Ingredient Name : " + ingredients.getIngredientName() + ",Calories " + ingredients.getCalories() + ",Category: " + ingredients.getCategory() + ", User id: " + ingredients.getIngredient_userid();
// Writing shops to log
            Log.d("Ingredients: : ", log);
        }

        for (Meals meals: mealses) {
            String log = "Id: " + meals.getMealId() + ",Meal Name: " + meals.getMealName() + ",LastName: " + meals.getMealCalories() + ",Weight: " + meals.getMealType() + ",Height: " + meals.getServings()
                    + " " + meals.getDietaryRestrictions() + " " + meals.getRecommendations() + " " + meals.getPublications() + " " + meals.getMeals_IngredientName() + " " + meals.getMeals_userID();
// Writing shops to log
            Log.d("Meals: : ", log);
        }



    }



    public void onClick(View view) {

    }


}



