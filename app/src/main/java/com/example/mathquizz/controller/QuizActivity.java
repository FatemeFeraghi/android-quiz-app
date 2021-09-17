package com.example.mathquizz.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mathquizz.R;
import com.example.mathquizz.model.Question;
import com.example.mathquizz.model.QuestionAnalyzer;
import com.example.mathquizz.model.QuestionRepository;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;


public class QuizActivity extends AppCompatActivity {
    public static final String QUESTION_INDEX = "QUESTION_INDEX";
    private final Locale locale = new Locale("en", "CA");
    private final QuestionRepository repository = new QuestionRepository();
    private int questionNumber = 0;
    private TextView textViewQuestionText;
    private Button answerButton1;
    private Button answerButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //R stands for resource
        //R is class utility which loads all the views from the app
        setContentView(R.layout.activity_main);

        textViewQuestionText = findViewById(R.id.question_text_view);

        View.OnClickListener buttonListener = view -> {

            final String answer = ((Button) view).getText().toString();
            QuestionAnalyzer questionAnalyzer = new QuestionAnalyzer();
            Question question = repository.getListQuestions().get(questionNumber);

            String message;
            try {
                NumberFormat format = NumberFormat.getInstance(locale);
                Number number = format.parse(answer);

                assert number != null;
                if (questionAnalyzer.isCorrectAnswer(question, number.doubleValue())) {
                    message = "Congrats, correct message";
                } else {
                    message = "Wrong answer!";
                }
            } catch (ParseException e) {
                message = e.getMessage();
            }


            Toast.makeText(QuizActivity.this, message, Toast.LENGTH_SHORT).show();

        };

        answerButton1 = findViewById(R.id.button_option1);
        answerButton1.setOnClickListener(buttonListener);

        answerButton2 = findViewById(R.id.button_option2);
        answerButton2.setOnClickListener(buttonListener);

        View.OnClickListener listenerNextQuestion = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                questionNumber++;
                if (questionNumber >= repository.getListQuestions().size()) {
                    questionNumber = 0;
                }
                displayQuestion(questionNumber);
            }
        };


        Button buttonNext = findViewById(R.id.button_next_question);
        buttonNext.setOnClickListener(listenerNextQuestion);

        if (savedInstanceState != null) {
            questionNumber = savedInstanceState.getInt(QUESTION_INDEX);
        }
        displayQuestion(questionNumber);
    }

    //This method is a reference to the Bundle object that pass into the onCreate method
    @Override
    protected void onSaveInstanceState (@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(QUESTION_INDEX, questionNumber);
    }

    public void displayQuestion (final int question_index) {
        Question question = repository.getListQuestions().get(question_index);
        textViewQuestionText.setText(question.getText());

        //Returns a formatted string using the specified locale, format string, and arguments
        String correctAnswer = String.format(locale, "%.2f", question.getCorrectAnswer());
        String wrongAnswer = String.format(locale, "%.2f", question.getWrongAnswer());

        answerButton1.setText(correctAnswer);
        answerButton2.setText(wrongAnswer);
    }
}