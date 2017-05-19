package com.example.csanders.getfit.Models;

import android.text.LoginFilter;

/**
 * Created by csanders on 5/12/2017.
 */

public class Users {
    public int userId;
<<<<<<< HEAD
    public String userName;
=======
    public String UserName;
    public int age;
>>>>>>> 7c718a07051ee3d3ac3f5746ebdad01beb15c270
    public int weight;
    public double height;
    public String password;


    public Users() {

    }

<<<<<<< HEAD
    public Users(String userName , String password)  {
        this.userName = userName;
        this.password = password;
    }

    public Users(String userName, int weight, double height) {
        this.userName = userName;
=======
    public Users(String UserName , String password)  {
        this.UserName = UserName;
        this.password = password;
    }

    public Users(String UserName, int weight, double height) {
        this.UserName = UserName;
>>>>>>> 7c718a07051ee3d3ac3f5746ebdad01beb15c270
        this.weight = weight;
        this.height = height;

    }

<<<<<<< HEAD
    public Users(int userId, String userName, String password, int weight, double height) {
        this.userId = userId;
        this.userName = userName;
=======
    public Users(int userId, String UserName, String password, int weight, double height) {
        this.userId = userId;
        this.UserName = UserName;
>>>>>>> 7c718a07051ee3d3ac3f5746ebdad01beb15c270
        this.password = password;
        this.weight = weight;
        this.height = height;
    }

<<<<<<< HEAD
    public Users(int userId, String userName, int weight, double height) {

        this.userId = userId;
        this.userName = userName;
=======
    public Users(int userId, String UserName, String Password, int age, int weight, double height) {

        this.userId = userId;
        this.UserName = UserName;
        this.password = Password;
        this.age = age;
>>>>>>> 7c718a07051ee3d3ac3f5746ebdad01beb15c270
        this.weight = weight;
        this.height = height;

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

<<<<<<< HEAD
        return this.userName;
    }
    public void setUserName(String first) {

        this.userName = first;
=======
        return this.UserName;
    }
    public void setUserName(String first) {

        this.UserName = first;
>>>>>>> 7c718a07051ee3d3ac3f5746ebdad01beb15c270
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
