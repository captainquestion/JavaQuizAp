package com.example.finalprojectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {


    String topic;
    List<QuestionModel> questionsList;
    RadioGroup radioGroup;
    RadioButton ansA, ansB, ansC, ansD;
    TextView questionText, scoreTExt, questionNoText;
    Button  submitBut;
    int totalQuestions;
    int qCounter = 0;
    int score;

    ColorStateList dfColor;
    boolean answered;
    QuestionModel currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        questionsList = new ArrayList<>();
        questionText = findViewById(R.id.textQuestion);
        questionNoText = findViewById(R.id.textQuestionNo);
        scoreTExt = findViewById(R.id.textScore);
        ansA = findViewById(R.id.rb1);
        ansB = findViewById(R.id.rb2);
        ansC = findViewById(R.id.rb3);
        ansD = findViewById(R.id.rb4);
        submitBut = findViewById(R.id.btnNext);
        radioGroup = findViewById(R.id.radioGroup);
        dfColor = ansA.getTextColors();




        addQuestions();

        totalQuestions = questionsList.size() - 5;

        showNextQuestions();



        submitBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(answered == false){
                    if(ansA.isChecked() || ansB.isChecked() || ansC.isChecked() || ansD.isChecked()){
                        checkAnswer();
                    }else{
                        Toast.makeText(QuizActivity.this, "Please Select an option", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    showNextQuestions();
                }
            }
        });

    }
    public void checkAnswer(){
        answered = true;

        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int ansNo = radioGroup.indexOfChild(rbSelected) + 1;
        if(ansNo == currentQuestion.getCorrectAnsNo()){

            score ++;
            scoreTExt.setText("Score: " + score);
        }
        ansA.setTextColor(Color.RED);
        ansB.setTextColor(Color.RED);
        ansC.setTextColor(Color.RED);
        ansD.setTextColor(Color.RED);

        switch (currentQuestion.getCorrectAnsNo()){
            case 1:
                ansA.setTextColor(Color.GREEN);
                break;
            case 2:
                ansB.setTextColor(Color.GREEN);
                break;
            case 3:
                ansC.setTextColor(Color.GREEN);
                break;

            case 4:
                ansD.setTextColor(Color.GREEN);
                break;
        }

        if(qCounter < totalQuestions){
            submitBut.setText("Next");
        }else{
            submitBut.setText("Finish");
        }
    }
    public void showNextQuestions(){

        radioGroup.clearCheck();

        ansA.setTextColor(dfColor);
        ansB.setTextColor(dfColor);
        ansC.setTextColor(dfColor);
        ansD.setTextColor(dfColor);
        if(qCounter < totalQuestions ){

            Random rand = new Random();

            int int_random = rand.nextInt(questionsList.size());

            currentQuestion = questionsList.get(int_random);
            questionText.setText(currentQuestion.getQuestion());
            ansA.setText(currentQuestion.getOption1());
            ansB.setText(currentQuestion.getOption2());
            ansC.setText(currentQuestion.getOption3());
            ansD.setText(currentQuestion.getOption4());



            questionsList.remove(currentQuestion);
            qCounter ++;


            submitBut.setText("Submit");
            questionNoText.setText("Question: " +qCounter+"/"+totalQuestions);
            answered = false;
            Log.d("totalQuestion", String.valueOf(totalQuestions));
            Log.d("qCounter", String.valueOf(qCounter));

        }else{


            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            intent.putExtra("Score", score);
            startActivity(intent);
        }
    }
    public void addQuestions(){
        Bundle scoreValue = getIntent().getExtras();
        topic = scoreValue.getString("Topic");
        Log.d("Topic", topic);

        switch (topic){
            case "math":
                questionsList.add(new QuestionModel("35 - 20 = ?","15","5","7","3",1));
                questionsList.add(new QuestionModel("40 - 30 = ?","11","10","13","14",2));
                questionsList.add(new QuestionModel("3 * 3 = ?","3","7","9","11",3));
                questionsList.add(new QuestionModel("4 / 2 = ?","3","4","1","2",4));
                questionsList.add(new QuestionModel("55 / 5 = ?","10","11","15","10",2));
                questionsList.add(new QuestionModel("6 * 5 = ?","15","36","30","24",3));
                questionsList.add(new QuestionModel("7 + 9 = ?","16","15","14","13",1));
                questionsList.add(new QuestionModel("8 / 4 = ?","1","3","4","2",4));
                questionsList.add(new QuestionModel("9 * 2 = ?","15","18","19","10",2));
                questionsList.add(new QuestionModel("10 - 3 = ?","11","8","7","6",3));
                break;
            case "sport":
                questionsList.add(new QuestionModel("In which sport was Mike Tyson popular?","Soccer","Boxing","Karate","Golf",2));
                questionsList.add(new QuestionModel("How many total players are there in a game of soccer?","11","22","20","18",2));
                questionsList.add(new QuestionModel("How many total players are there in a game of basketball?","10","11","12","13",3));
                questionsList.add(new QuestionModel("Which chess piece can only move diagonally?","Pawn","Rook","Knight","Bishop",4));
                questionsList.add(new QuestionModel("In which sport might you do a slam dunk?","Basketball","Soccer","Golf","Boxing",1));
                questionsList.add(new QuestionModel("How many goals are scored if a player has a hat-trick?","1","2","3","4",3));
                questionsList.add(new QuestionModel("What colour belt are martial arts experts entitled to wear?","Black","Yellow","Blue","White",1));
                questionsList.add(new QuestionModel("How many bases are there on a baseball field?","1","2","3","4",4));
                questionsList.add(new QuestionModel("How many players are on a baseball team?","7","8","9","10",3));
                questionsList.add(new QuestionModel("What sport is played at Wimbledon?","Swimming","Golf","Tennis","Soccer",3));
                break;
            case "geo":
                questionsList.add(new QuestionModel("Which country has the largest population in the world?","China","Russia","India","USA",1));
                questionsList.add(new QuestionModel("What is the name of the biggest ocean on Earth?","Atlantic","Pacific","Arctic","Indian",2));
                questionsList.add(new QuestionModel("Which is the highest mountain in the world?","Washington","Whitney","Everest","St.Helens",3));
                questionsList.add(new QuestionModel("Which of these is not a continent?","Alaska","South America","Antartica","Africa",1));
                questionsList.add(new QuestionModel("What is the capital city of Canada?","Toronto","Ottawa","Vancouver","Montreal",2));
                questionsList.add(new QuestionModel("Which is the largest country by land in the world?","Canada","India","Russia","USA",3));
                questionsList.add(new QuestionModel("Which is the coldest continent in the world?","Antartica","Europe","Asia","North America",1));
                questionsList.add(new QuestionModel("Which planet is closest to Planet Earth?","Mars","Mercury","Jupiter","Venus",4));
                questionsList.add(new QuestionModel("Which city is located in two continents ? ","Rome","Istanbul","Athens","Moscow",2));
                questionsList.add(new QuestionModel("Which country is also known as the Netherlands?","Germany","France","Holland","Polland",3));
                break;
            case "animal":
                questionsList.add(new QuestionModel("How many legs does an octopus have?","8","7","6","5",1));
                questionsList.add(new QuestionModel("Which is the tallest animal in the world?","Elephant","Giraffe","Ostrich","Lion",2));
                questionsList.add(new QuestionModel("Which is the fastest animal?","Horse","Dog","Cheetah","Cat",3));
                questionsList.add(new QuestionModel("Which is the only mammal that can fly?","Owl","Crow","Seagull","Bat",4));
                questionsList.add(new QuestionModel("Which bird is the symbol of peace?","Bunny","Dove","Elephant","Sheep",2));
                questionsList.add(new QuestionModel("Which is the tallest bird in the world?","Penguin","Bat","Ostrich","Bat",3));
                questionsList.add(new QuestionModel("What is the largest mammal?","Whale","Elephant","Giraffe","Dolphin",1));
                questionsList.add(new QuestionModel("Which animal is considered to be the human’s best friend?","Birds","Cat","Snake","Dog",4));
                questionsList.add(new QuestionModel("What animal is said to have 9 lives?","Dog","Cat","Dove","Crow",2));
                questionsList.add(new QuestionModel("Which of these animal is not nocturnal?","Owl","Racoon","Sheep","Bat",3));
                break;
        }



    }
}