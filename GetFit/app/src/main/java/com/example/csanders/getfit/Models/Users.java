package com.example.csanders.getfit.Models;

import android.text.LoginFilter;

/**
 * Created by csanders on 5/12/2017.
 */

public class Users {
    public int userId;
    public String userName;
    public int age;
    public int weight;
    public double height;
    public String Goal;
    public String password;


    public Users() {

    }

    public Users(String userName , String password)  {
        this.userName = userName;
        this.password = password;
    }

    public Users(String UserName, int weight, double height) {
        this.userName = UserName;
        this.weight = weight;
        this.height = height;

    }

    public Users(int userId, String userName, String password, int weight, double height) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.weight = weight;
        this.height = height;
    }

    public Users(int userId, String userName, String Password, int age, int weight, double height, String Goal) {

        this.userId = userId;
        this.userName = userName;
        this.password = Password;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.Goal = Goal;

    }


    public Users(int userId, String userName, String Password, int age, int weight, double height) {

        this.userId = userId;
        this.userName = userName;
        this.password = Password;
        this.age = age;
        this.weight = weight;
        this.height = height;

    }

    public String getGoal() {

        return this.Goal;
    }


    public void setGoal(String goal) {

        this.Goal = goal;
    }


    public int getAge() {

        return this.age;
    }

    public void setAge(int age) {

        this.age = age;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {

        return this.userId;
    }
    public void setUserId(int id) {

        this.userId = id;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setUserName(String first) {
        this.userName = first;
    }
    public int getWeight() {

        return this.weight;
    }
    public void setWeight(int mass) {

        this.weight = mass;
    }
    public double getHeight() {

        return this.height;
    }
    public void setHeight(double tall) {

        this.height = tall;
    }
}
