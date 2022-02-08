package com.example.quese.models;

public class GameGenerator {
    String gameNamber;
    String image;
    User_fire answerOne;
    User_fire answerTwo;
    User_fire answerThree;
    User_fire answerFour;

    public GameGenerator() {

    }

    public GameGenerator(String gameNamber, String image, User_fire answerOne, User_fire answerTwo, User_fire answerThree, User_fire answerFour) {
        this.gameNamber = gameNamber;
        this.image = image;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
    }

    public String getGameNamber() {
        return gameNamber;
    }

    public void setGameNamber(String gameNamber) {
        this.gameNamber = gameNamber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public User_fire getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(User_fire answerOne) {
        this.answerOne = answerOne;
    }

    public User_fire getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(User_fire answerTwo) {
        this.answerTwo = answerTwo;
    }

    public User_fire getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(User_fire answerThree) {
        this.answerThree = answerThree;
    }

    public User_fire getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(User_fire answerFour) {
        this.answerFour = answerFour;
    }
}
