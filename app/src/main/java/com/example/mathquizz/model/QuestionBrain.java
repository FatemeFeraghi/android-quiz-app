package com.example.mathquizz.model;

public class QuestionBrain {
    //This method will return boolean
    //answer is the answer given by the user
    public boolean isCorrestAnswer(Question question, double answer){
        return question.getCorrectAnswer() == answer;
    }
}
