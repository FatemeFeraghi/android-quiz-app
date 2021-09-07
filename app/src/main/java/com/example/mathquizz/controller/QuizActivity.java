package com.example.mathquizz.controller;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.text.NumberFormat;
import  java.text.ParseException;
import java.util.Locale;
import com.example.mathquizz.model.QuestionBrain;

import com.example.mathquizz.R;
import com.example.mathquizz.model.Question;
import com.example.mathquizz.model.QuestionRepository;


public class QuizActivity extends AppCompatActivity {

    private QuestionRepository repository = new QuestionRepository();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R stands for research
        // R is class utility which loads all the views from the app
        setContentView(R.layout.activity_main);

        Question question = repository.getListQuestions().get(0);

        //R is utility class
        TextView label = findViewById(R.id.textView);
        label.setText(question.getText());

        Button button = findViewById(R.id.button);
        button.setText(String.valueOf(question.getCorrectAnswer()));

        Button button2 = findViewById(R.id.button2);
        button.setText(String.valueOf(question.getWrongAnswer()));

        Button buttonResult = findViewById(R.id.button3);
        button.setText("Next Question");
    }

}