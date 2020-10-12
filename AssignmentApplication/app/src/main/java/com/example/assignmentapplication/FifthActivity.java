package com.example.assignmentapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public class FifthActivity extends AppCompatActivity {

    Button false_btn, true_btn, repeat, cancel;
    TextView textView, scores;
    ProgressBar progressBar;
    int score = 0;
    int rand = 0;

    private Dialog openDialog;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);


        openDialog = new Dialog(this);
        textView = findViewById(R.id.question);
        false_btn = findViewById(R.id.btnf);
        true_btn = findViewById(R.id.btnt);

        final String rr = getIntent().getExtras().getString("rand");
        String ss = getIntent().getExtras().getString("score");
        final String rand1 = getIntent().getExtras().getString("rand1");
        //Toast.makeText(FifthActivity.this, rr, Toast.LENGTH_SHORT).show();

        Random random = new Random();
        int upperBound = 6;
        rand = random.nextInt(upperBound);

        score = score + Integer.parseInt(ss);



        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(5);
        progressBar.setProgress(4);

        final QuestionClass ques = new QuestionClass();


        textView.setText(ques.questions[rand]);

        true_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(FifthActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(FifthActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                }

                showPopup(String.valueOf(score));
            }
        });

        false_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ques.answers[rand].equals("Yes")) {
                    Toast.makeText(FifthActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                    score++;
                } else {
                    Toast.makeText(FifthActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                }

                showPopup(String.valueOf(score));
            }
        });
    }


    private void showPopup(final String title) {

        openDialog.setContentView(R.layout.dialogbox);
        repeat = openDialog.findViewById(R.id.rep); //Closes Dialog Box
        cancel = openDialog.findViewById(R.id.can); // Starts Downloading
        scores = openDialog.findViewById(R.id.enterScore);

        scores.setText(title);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog.dismiss();
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FifthActivity.this, MainActivity.class));
            }
        });

        openDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        openDialog.show();

    }
}