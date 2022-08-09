package com.example.finalprojectjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvScore, tvDesc;
    Button buttonScore;
    ImageView imageTrophy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvScore = findViewById(R.id.textViewScore);
        tvDesc = findViewById(R.id.textViewDesc);
        imageTrophy = findViewById(R.id.imageView);
        buttonScore = findViewById(R.id.buttonRes);


        Bundle scoreValue = getIntent().getExtras();
        int scoreRes = scoreValue.getInt("Score");
        tvScore.setText(scoreRes+"/"+"5");

        if (scoreRes < 3 ) {
            imageTrophy.setImageResource(R.drawable.sad);
            tvDesc.setText("Please Try Again!");
        }else if (scoreRes == 3){
            imageTrophy.setImageResource(R.drawable.bronze);
            tvDesc.setText("Good Job!");
        }else if(scoreRes == 4){
            imageTrophy.setImageResource(R.drawable.silver);
            tvDesc.setText("Excellent Work!");
        }else{
            imageTrophy.setImageResource(R.drawable.gold);
            tvDesc.setText("You are a genius");
        }


        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}