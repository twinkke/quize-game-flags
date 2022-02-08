package com.example.quese.models;

public class User_fire {
    public String  name, score;


    public User_fire() {
    }

    public User_fire(String name, String score) {
        //this.icon = icon;
        this.name = name;
        this.score = score;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
