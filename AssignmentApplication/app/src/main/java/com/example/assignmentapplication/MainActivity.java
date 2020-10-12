package com.example.assignmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button false_btn, true_btn;
    TextView textView;
    ProgressBar progressBar;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.question);
        false_btn = findViewById(R.id.btnf);
        true_btn = findViewById(R.id.btnt);


        Random random = new Random();
        int upperBound = 6;
        final int rand = random.nextInt(upperBound);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(5);
        progressBar.setProgress(1);

        final QuestionClass ques = new QuestionClass();


        textView.setText(ques.questions[rand]);

        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(2);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("rand", String.valueOf(rand));
                intent.putExtra("score", String.valueOf(score));
                startActivity(intent);
            }
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(2);
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("rand", String.valueOf(rand));
                intent.putExtra("score", String.valueOf(score));
                startActivity(intent);
            }
        });

    }
}