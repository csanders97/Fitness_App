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
    private int workout_user_id;



    public  Workouts() {

    }

    public Workouts(String workoutName,String workoutType,int length) {

        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;

    }

    public Workouts(int workoutId,String workoutName,String workoutType,int length) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;

    }

    public Workouts(int workoutId,String workoutName,String workoutType,int length, int workout_user_id) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;
        this.workout_user_id = workout_user_id;

    }

    public Workouts(int workoutId,String workoutName,String workoutType, String equipment, int length, int workout_user_id) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.equipment = equipment;
        this.length = length;
        this.workout_user_id = workout_user_id;

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
}
