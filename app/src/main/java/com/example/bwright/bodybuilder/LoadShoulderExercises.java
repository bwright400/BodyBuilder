package com.example.bwright.bodybuilder;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by bwrig on 7/15/2017.
 */

public class LoadShoulderExercises extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_workouts);

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // this is data for recycler view
        NewWorkout newWorkout = new NewWorkout();

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. create an adapter
        ExerciseAdapter mAdapter = new ExerciseAdapter(newWorkout.getShoulders());

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
}
