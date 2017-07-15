package com.example.bwright.bodybuilder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainWorkout extends AppCompatActivity {

    private List<List<String>> workoutList = new ArrayList<>();
    private List<String> workoutTitles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // 1. get a reference to recyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        // this is data for recycler view
        NewWorkout newWorkout = new NewWorkout();

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. create an adapter
        WorkoutAdapter mAdapter = new WorkoutAdapter(newWorkout.getTitles());

        // 4. set adapter
        recyclerView.setAdapter(mAdapter);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());




//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
//
//        //workoutsAdapter = new WorkoutsAdapter(workoutList, workoutTitles);
//        RecyclerView.LayoutManager wLayoutManager = new LinearLayoutManager(getApplicationContext());
//        recyclerView.setLayoutManager(wLayoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
//        //recyclerView.setAdapter(workoutsAdapter);
//
//        prepareWorkoutList();
    }


//    private void prepareWorkoutList() {
//        NewWorkout newWorkout = new NewWorkout();
//
//        workoutTitles.add(newWorkout.getTitleForCore());
//        workoutTitles.add(newWorkout.getTitleForLowerBody());
//        workoutTitles.add(newWorkout.getTitleForChest());
//        workoutTitles.add(newWorkout.getTitleForShoulders());
//        workoutTitles.add(newWorkout.getTitleForBack());
//        workoutTitles.add(newWorkout.getTitleForArms());
//        workoutTitles.add(newWorkout.getTitleForCardio());
//        workoutTitles.add(newWorkout.getTitleForStretches());
//
//        workoutList.add(newWorkout.getCore());
//        workoutList.add(newWorkout.getLowerBody());
//        workoutList.add(newWorkout.getChest());
//        workoutList.add(newWorkout.getShoulders());
//        workoutList.add(newWorkout.getBack());
//        workoutList.add(newWorkout.getArms());
//        workoutList.add(newWorkout.getCardio());
//        workoutList.add(newWorkout.getStretches());
//
//        //workoutsAdapter.notifyDataSetChanged();
//    }

}
