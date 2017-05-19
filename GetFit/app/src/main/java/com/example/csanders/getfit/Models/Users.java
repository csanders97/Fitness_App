package com.example.csanders.getfit.Models;

/**
 * Created by csanders on 5/12/2017.
 */

public class Users {
    public int userId;
    public String firstName;
    public String lastName;
    public int weight;
    public double height;
    public String password;


    public Users() {

    }

    public Users(String firstName , String password)  {
        this.firstName = firstName;
        this.password = password;
    }

    public Users(String firstName, String lastName, int weight, double height) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;

    }

    public Users(int userId, String firstName, String password, String lastName, int weight, double height) {
        this.userId = userId;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.weight = weight;
        this.height = height;
    }

    public Users(int userId, String firstName, String lastName, int weight, double height) {

        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
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
    public String getFirstName() {

        return this.firstName;
    }
    public void setFirstName(String first) {

        this.firstName = first;
    }
    public String getLastName() {

        return this.lastName;
    }
    public void setLastName(String last) {

        this.lastName = last;
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
