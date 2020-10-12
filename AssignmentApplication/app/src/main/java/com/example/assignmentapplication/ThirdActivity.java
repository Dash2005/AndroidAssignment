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

public class ThirdActivity extends AppCompatActivity {

    Button false_btn, true_btn;
    TextView textView;
    ProgressBar progressBar;
    int score = 0;
    int rand = 0;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);


        textView = findViewById(R.id.question);
        false_btn = findViewById(R.id.btnf);
        true_btn = findViewById(R.id.btnt);

        final String rr = getIntent().getExtras().getString("rand");
        String ss = getIntent().getExtras().getString("score");
        final String rand1 = getIntent().getExtras().getString("rand1");
        //Toast.makeText(ThirdActivity.this, rr, Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int upperBound = 6;
        rand = random.nextInt(upperBound);

        score = score + Integer.parseInt(ss);



        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(5);
        progressBar.setProgress(3);

        final QuestionClass ques = new QuestionClass();


        textView.setText(ques.questions[rand]);

        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(ThirdActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(ThirdActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(4);
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("rand", rand);
                intent.putExtra("rand1", rr);
                intent.putExtra("rand2", rand1);
                intent.putExtra("score", String.valueOf(score));
                startActivity(intent);
            }
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(ThirdActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(ThirdActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(4);
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("rand", rand);
                intent.putExtra("rand1", rr);
                intent.putExtra("rand2", rand1);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });

    }
}