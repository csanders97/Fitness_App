package com.example.csanders.getfit.Models;

/**
 * Created by csanders on 5/12/2017.
 */

public class Workouts {
    private int workoutId;
    private String workoutName;
    private String workoutType;
    private int length;



    public void Workouts() {

    }

    public void Workouts(int workoutId,String workoutName,String workoutType,int length) {

        this.workoutId = workoutId;
        this.workoutName  = workoutName;
        this.workoutType = workoutType;
        this.length = length;

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
