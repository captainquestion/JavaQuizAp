package com.example.finalprojectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopicActivity extends AppCompatActivity {

    Button sportButton, mathButton, geoButton, animalsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        sportButton = findViewById(R.id.sportButton);
        mathButton = findViewById(R.id.mathButton);
        geoButton = findViewById(R.id.geographyButton);
        animalsButton = findViewById(R.id.animalButton);

        sportButton.setOnClickListener(onClickListener);
        mathButton.setOnClickListener(onClickListener);
        geoButton.setOnClickListener(onClickListener);
        animalsButton.setOnClickListener(onClickListener);


    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.sportButton:
                    Intent i = new Intent(TopicActivity.this, QuizActivity.class);
                    i.putExtra("Topic", "sport");
                    startActivity(i);
                    break;
                case R.id.mathButton:
                    Intent i2 = new Intent(TopicActivity.this, QuizActivity.class);
                    i2.putExtra("Topic", "math");
                    startActivity(i2);
                    break;
                case R.id.geographyButton:
                    Intent i3 = new Intent(TopicActivity.this, QuizActivity.class);
                    i3.putExtra("Topic", "geo");
                    startActivity(i3);
                    break;
                case R.id.animalButton:
                    Intent i4 = new Intent(TopicActivity.this, QuizActivity.class);
                    i4.putExtra("Topic", "animal");
                    startActivity(i4);
                    break;
            }

        }
    };
}