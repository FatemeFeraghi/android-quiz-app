package com.example.mathquizz.model;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {

    public List<Question> getListQuestions(){

        ArrayList<Question> questions = new ArrayList<Question>();

        Question q1 = new Question("In a clothing store, 1500 clothes are sold daily for 7 days. How many days will 200 clothes be sold?"
                , 1, 4);
        Question q2 = new Question("In a steakhouse, 5 pigs are roasted, out of a total of 10. If it is necessary to roast 3 pigs for 50 people, how many pigs will need to be roasted for 250 people?"
                , 15, 20);
        Question q3 = new Question("In a print shop there are 3 printers that work without interruption, 10 hours a day, for 4 days, printing 240,000 sheets. Having broken one of the printers and needing to print 480,000 sheets in 6 days, how many hours a day should the remaining two machines run uninterrupted?"
                ,20,10);
        Question q4 = new Question("Applying R$500.00 in savings, the amount of interest in a month would be R$2.50. If BRL 2100.00 is applied in the same month, what would be the interest amount?"
                ,14,10.50);
        Question q5 = new Question("A plant produces 500 liters of alcohol from 6000 kg of sugarcane. Determine how many liters of alcohol are produced with 15000 kg of sugarcane."
                ,750, 1250);

       questions.add(q1);
       questions.add(q2);
       questions.add(q3);
       questions.add(q4);
       questions.add(q5);

       return questions;
    }
}
