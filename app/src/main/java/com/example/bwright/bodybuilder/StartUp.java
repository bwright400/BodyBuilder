package com.example.bwright.bodybuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class StartUp extends AppCompatActivity {
    private Button newWorkout, workoutHistory, signOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        newWorkout = (Button) findViewById(R.id.button2);
        workoutHistory = (Button) findViewById(R.id.button5);
        signOut = (Button) findViewById(R.id.button6);

    }

    public void goToNewWorkout(View view) {
        newWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartUp.this, LoadWorkouts.class);
                startActivity(intent);
            }
        });
    }
    public void goToWorkoutHistory(View view) {
        workoutHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(StartUp.this, MainActivity.class);
            }
        });
    }
    public void goToSignOut(View view) {
        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartUp.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
