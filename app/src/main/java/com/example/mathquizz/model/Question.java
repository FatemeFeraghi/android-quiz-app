package com.example.mathquizz.model;

public class Question {

    private String text;
    private double correctAnswer;
    private double wrongAnswer;

    //Constructor
    public Question(String text, double correctAnswer, double wrongAnswer){
        //this refers to the constructor of the current object
        this.text = text;
        this.correctAnswer = correctAnswer;
        this.wrongAnswer = wrongAnswer;
    }

    public String getText(){return text;}
    public double getCorrectAnswer(){return correctAnswer;}
    public double getWrongAnswer(){return wrongAnswer;}


}
