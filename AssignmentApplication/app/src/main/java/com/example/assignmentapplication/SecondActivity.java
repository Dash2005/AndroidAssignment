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

public class SecondActivity extends AppCompatActivity {

    Button false_btn, true_btn;
    TextView textView;
    ProgressBar progressBar;
    int s1 = 0;
    int rand = 0;
    String rr;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        textView = findViewById(R.id.question);
        false_btn = findViewById(R.id.btnf);
        true_btn = findViewById(R.id.btnt);

        rr = getIntent().getExtras().getString("rand");
        String ss = getIntent().getExtras().getString("score");
        Toast.makeText(SecondActivity.this, rr, Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int upperBound = 6;
        rand = random.nextInt(upperBound);

        s1 = s1 + Integer.parseInt(ss);




        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(5);
        progressBar.setProgress(2);


        final QuestionClass ques = new QuestionClass();


        textView.setText(ques.questions[rand]);


        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(SecondActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    s1++;
                } else {
                    Toast.makeText(SecondActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(3);
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("rand", rand);
                intent.putExtra("rand1", rr);
                intent.putExtra("score", String.valueOf(s1));
                startActivity(intent);
            }
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(SecondActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    s1++;
                } else {
                    Toast.makeText(SecondActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                }

                progressBar.setProgress(3);
                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                intent.putExtra("rand", rand);
                intent.putExtra("rand1", Integer.parseInt(rr));
                intent.putExtra("score", s1);
                startActivity(intent);
            }
        });
        
    }
}