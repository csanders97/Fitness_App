package com.example.csanders.getfit.Models;

/**
 * Created by csanders on 5/12/2017.
 */

public class Workouts {
    private int workoutId;
    private String workoutName;
    private String workoutType;
    private String equipment;
    private int length;
    private int caloriesBurned;
    private String workoutPublished;
    private String workoutInstructions;
    private int workout_user_id;



    public  Workouts() {

    }

    public Workouts(String workoutName,String workoutType,int length) {

        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;


    }

    public Workouts(String workoutName,String workoutType, String equipment, int length,int caloriesBurned, String workoutPublish, String workoutWalkthrough, int workout_user_id) {

        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.equipment = equipment;
        this.length = length;
        this.caloriesBurned = caloriesBurned;
        this.workoutPublished = workoutPublish;
        this.workoutInstructions = workoutWalkthrough;
        this.workout_user_id = workout_user_id;

    }

    public Workouts(int workoutId,String workoutName,String workoutType,int length) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;

    }

    public Workouts(int workoutId,String workoutName,String workoutType,String equipment, int length,int caloriesBurned, String workoutPublish, String workoutWalkthrough, int workout_user_id) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;
        this.caloriesBurned = caloriesBurned;
        this.workout_user_id = workout_user_id;

    }

    public Workouts(int workoutId,String workoutName,String workoutType, String equipment, int length,int workout_user_id) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.equipment = equipment;
        this.length = length;
        this.workout_user_id = workout_user_id;

    }

    public Workouts(int workoutId,String workoutName,String workoutType, String equipment, int length, int caloriesBurned, int workout_user_id) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.equipment = equipment;
        this.length = length;
        this.caloriesBurned = caloriesBurned;
        this.workout_user_id = workout_user_id;

    }

    public int getCaloriesBurned() {

        return caloriesBurned;
    }

    public void setCaloriesBurned(int burned) {

        this.caloriesBurned = burned;
    }

    public String getEquipment() {

        return equipment;
    }

    public void setEquipment(String equipment) {

        this.equipment = equipment;
    }
    public int getWorkout_user_id() {

        return workout_user_id;
    }

    public void setWorkout_user_id(int workout_user_id) {

        this.workout_user_id = workout_user_id;
    }

    public int getWorkoutId()
    {

        return this.workoutId;
    }
    public void setWorkoutId(int id)
    {

        this.workoutId = id;
    }
    public String getWorkoutName() {

        return this.workoutName;
    }
    public void setWorkoutName(String name) {

        this.workoutName = name;
    }
    public String getWorkoutType() {

        return this.workoutType;
    }
    public void setWorkoutType(String type) {

        this.workoutType = type;
    }
    public int getLength()
    {

        return this.length;
    }
    public void setLength(int time)
    {

        this.length = time;
    }
    public String getWorkoutPublished() {
        return this.workoutPublished;
    }
    public void setWorkoutPublished(String publish) {
        this.workoutPublished = publish;
    }
    public String getWorkoutInstructions() {
        return this.workoutInstructions;
    }
    public void setWorkoutInstructions(String instruct) {
        this.workoutInstructions = instruct;
    }
}
