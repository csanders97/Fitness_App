package com.example.csanders.getfit.Models;

/**
 * Created by csanders on 5/12/2017.
 */

public class Users {
    public int userId;
    public String userName;
    public int weight;
    public double height;
    public String password;


    public Users() {

    }

    public Users(String userName , String password)  {
        this.userName = userName;
        this.password = password;
    }

    public Users(String userName, int weight, double height) {
        this.userName = userName;
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

    public Users(int userId, String userName, int weight, double height) {

        this.userId = userId;
        this.userName = userName;
        this.weight = weight;
        this.height = height;

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
