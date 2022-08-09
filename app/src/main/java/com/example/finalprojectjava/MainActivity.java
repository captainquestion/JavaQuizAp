package com.example.finalprojectjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button btnStart1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart1 = findViewById(R.id.btnStart);

        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inting = new Intent(MainActivity.this, TopicActivity.class);
                startActivity(inting);
            }
        });
    }
}