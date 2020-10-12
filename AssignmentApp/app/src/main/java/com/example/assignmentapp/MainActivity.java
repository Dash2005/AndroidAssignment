package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Dialog openDialog;

    Button false_btn, true_btn, repeat, cancel;
    TextView textView, scores;
    ProgressBar progressBar;
    String c;
    int score = 0, count = 0;
    boolean flag = false;
    int loop = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openDialog = new Dialog(this);

        textView = findViewById(R.id.question);
        false_btn = findViewById(R.id.btnf);
        true_btn = findViewById(R.id.btnt);

        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(5);
        progressBar.setProgress(0);

        final QuestionClass questionClass = new QuestionClass();

        if (count == 0)
            textView.setText(questionClass.questions1[0]);
        if (count > 0)
            textView.setText(questionClass.questions2[0]);


            true_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (count > 0) {
                        if (questionClass.answers2[loop].equals("Yes")) {
                            Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();
                        }

                        if (loop < 4) {
                            loop++;
                            textView.setText(questionClass.questions2[loop]);
                            progressBar.setProgress(loop);
                        } else {
                            textView.setText(questionClass.questions2[4]);
                            progressBar.setProgress(5);
                            showPopup(String.valueOf(score));
                        }

                    } else if (count == 0) {
                        if (questionClass.answers1[loop].equals("Yes")) {
                            Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                            score++;
                        } else {
                            Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();

                        }

                        if (loop < 4) {
                            loop++;
                            textView.setText(questionClass.questions1[loop]);
                            progressBar.setProgress(loop);
                        } else {
                            textView.setText(questionClass.questions1[4]);
                            progressBar.setProgress(5);
                            showPopup(String.valueOf(score));
                        }
                    }

                }
            });

            false_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (count > 0) {
                        if (questionClass.answers2[loop].equals("Yes")) {
                            Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                            score++;
                        }

                        if (loop < 4) {
                            loop++;
                            textView.setText(questionClass.questions2[loop]);
                            progressBar.setProgress(loop);
                        } else {
                            textView.setText(questionClass.questions2[4]);
                            progressBar.setProgress(5);
                            showPopup(String.valueOf(score));
                        }

                    } else if (count == 0) {
                        if (questionClass.answers1[loop].equals("Yes")) {
                            Toast.makeText(MainActivity.this, "Wrong Answer!", Toast.LENGTH_SHORT).show();

                        } else {
                            Toast.makeText(MainActivity.this, "Right Answer!", Toast.LENGTH_SHORT).show();
                            score++;
                        }

                        if (loop < 4) {
                            loop++;
                            textView.setText(questionClass.questions1[loop]);
                            progressBar.setProgress(loop);
                        } else {
                            textView.setText(questionClass.questions1[4]);
                            progressBar.setProgress(5);
                            showPopup(String.valueOf(score));
                        }
                    }

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
                finish();
            }
        });

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (flag == false) {
                    count = 1;
                    progressBar.setProgress(0);
                    score = 0;
                    loop = 0;
                    QuestionClass questionClass = new QuestionClass();
                    openDialog.dismiss();
                    textView.setText(questionClass.questions2[0]);
                    flag = true;
                } else if (flag == true) {
                    count = 0;
                    progressBar.setProgress(0);
                    score = 0;
                    loop = 0;
                    QuestionClass questionClass = new QuestionClass();
                    openDialog.dismiss();
                    textView.setText(questionClass.questions1[0]);
                    flag = false;
                }
            }
        });

        openDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        openDialog.show();

    }
}