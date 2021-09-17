package com.example.mathquizz.model;

public class QuestionAnalyzer {
    //This method will return boolean
    //answer is the answer given by the user
    public boolean isCorrectAnswer(Question question, double answer){
        return question.getCorrectAnswer() == answer;
    }
}
