package com.example.csanders.getfit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.csanders.getfit.Models.Ingredients;
import com.example.csanders.getfit.Models.Meals;
import com.example.csanders.getfit.Models.Users;
import com.example.csanders.getfit.Models.Workouts;
import com.example.csanders.getfit.Tables.DBHandler;
import com.example.csanders.getfit.Views.Home;

import java.util.List;

//IM YOUR DADDY CALEB

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private Button regClick;
    private Button logClick;
    private EditText userName;
    private EditText pass;
    private String name;
    private String password;
    DBHandler db = new DBHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        regClick = (Button) findViewById(R.id.registerbtn);
        regClick.setOnClickListener(this);
        logClick = (Button) findViewById(R.id.loginbtn);
        logClick.setOnClickListener(this);
        pass = (EditText) findViewById(R.id.passwordinput);
        password = pass.getText().toString();






// Inserting Shop/Rows
//        Log.d("Insert: ", "Inserting ..");
//        db.addUsers(new Users("Billy", "Bob", 300 , 6));
//        db.addIngredients(new Ingredients(1,"Carrot",10,"Vegatable",1));
//        db.addMeals(new Meals(1,"Salad",190,1,"5-17-2017","Lunch" ," ", " Weight Loss", 1, "Lettuce"));
//        db.addWorkouts(new Workouts(1,"Treadmill" , "Cardio", 30,1));




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
                    + "DietaryRestrictions: " + meals.getDietaryRestrictions() + "Recommendations: " + meals.getRecommendations() + "Publications: " + meals.getPublications() + "Meals IngredientName: " + meals.getMeals_IngredientName() + "Meal UserID: " + meals.getMeals_userID();
// Writing shops to log
            Log.d("Meals: : ", log);
        }



    }



    public void onClick(View view) {
        userName = (EditText) findViewById(R.id.usernameinput);
        name = userName.getText().toString();

        switch (view.getId()) {

            case R.id.registerbtn:

                break;

            case R.id.loginbtn:
                Intent intent =  new Intent(this, Home.class);
                startActivity(intent);
                break;
        }


    }


}



