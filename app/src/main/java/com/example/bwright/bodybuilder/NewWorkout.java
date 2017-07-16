package com.example.bwright.bodybuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bwrig on 7/9/2017.
 */



public class NewWorkout {
    private List<String> titles, core, lower_body, chest, shoulders, back, arms, cardio, stretches;
    private final String titleForCore, titleForLowerBody, titleForChest, titleForShoulders, titleForBack, titleForArms, titleForCardio, titleForStretches;

    public NewWorkout() {
        this.titleForCore = "Core";
        this.titleForLowerBody = "Lower Body";
        this.titleForChest = "Chest";
        this.titleForShoulders = "Shoulders";
        this.titleForBack = "Back";
        this.titleForArms = "Arms";
        this.titleForCardio = "Cardio";
        this.titleForStretches = "Stretches";

        this.titles = new ArrayList<>();
        this.core = new ArrayList<>();
        this.lower_body = new ArrayList<>();
        this.chest = new ArrayList<>();
        this.shoulders = new ArrayList<>();
        this.back = new ArrayList<>();
        this.arms = new ArrayList<>();
        this.cardio = new ArrayList<>();
        this.stretches = new ArrayList<>();

        setUpTitles();
        setUpCoreList();
        setUpLowerBodyList();
        setUpChestList();
        setUpShouldersList();
        setUpBackList();
        setUpArmsList();
        setUpCardioList();
        setUpStretchList();
    }

    private void setUpTitles() {
        titles.add(getTitleForCore());
        titles.add(getTitleForLowerBody());
        titles.add(getTitleForChest());
        titles.add(getTitleForShoulders());
        titles.add(getTitleForBack());
        titles.add(getTitleForArms());
        titles.add(getTitleForCardio());
        titles.add(getTitleForStretches());
    }

    private void setUpCoreList() {
        core.add("Crunch's");
        core.add("Push Ups");
        core.add("Planks");
        core.add("Raised Knee-In's");
        core.add("Flutter Kicks");
    }

    private void setUpLowerBodyList() {
        lower_body.add("Squats");
        lower_body.add("Leg Extension");
        lower_body.add("Leg Press");
        lower_body.add("Lunges");
        lower_body.add("Calf Raises");
    }

    private void setUpChestList() {
        chest.add("Bench Press");
        chest.add("Dumbbell Press");
        chest.add("Dumbbell Flyes");
        chest.add("Abdomen Extensions");
        chest.add("Plyometric Push Ups");
    }

    private void setUpShouldersList() {
        shoulders.add("Upright Cable Row");
        shoulders.add("Front Barbell Raise");
        shoulders.add("Cable Front Raise");
        shoulders.add("Machine Shoulder Press");
        shoulders.add("Leaning Dumbbell Lateeral Raise");
    }

    private void setUpBackList() {
        back.add("Barbell Deadlift");
        back.add("Bent-Over Barbell Deadlift");
        back.add("Wide-Grip Pull-Ups");
        back.add("Standing T-Bar Row");
    }

    private void setUpArmsList() {
        arms.add("Hammer Curl's");
        arms.add("Dips");
        arms.add("Neutral Grip Triceps Extension");
        arms.add("EZ Bar Preacher Curl");
        arms.add("Overhead Press");
    }

    private void setUpCardioList() {
        cardio.add("Stair Climb");
        cardio.add("Treadmill Running");
        cardio.add("Cycling");
        cardio.add("Swimming");
    }

    private void setUpStretchList() {
        stretches.add("Runner's Stretch");
        stretches.add("Standing Side Stretch");
        stretches.add("Forward Hang");
        stretches.add("Low Lunge Arch");
        stretches.add("Seated Back Twist");
    }



    private String getTitleForCore() {
        return titleForCore;
    }

    private String getTitleForLowerBody() {
        return titleForLowerBody;
    }

    private String getTitleForChest() {
        return titleForChest;
    }

    private String getTitleForShoulders() {
        return titleForShoulders;
    }

    private String getTitleForBack() {
        return titleForBack;
    }

    private String getTitleForArms() {
        return titleForArms;
    }

    private String getTitleForCardio() {
        return titleForCardio;
    }

    private String getTitleForStretches() {
        return titleForStretches;
    }

    public List<String> getTitles() {
        return titles;
    }

    public List<String> getCore() {
        return core;
    }

    public List<String> getLowerBody() {
        return lower_body;
    }

    public List<String> getChest() {
        return chest;
    }

    public List<String> getShoulders() {
        return shoulders;
    }

    public List<String> getBack() {
        return back;
    }

    public List<String> getArms() {
        return arms;
    }

    public List<String> getCardio() {
        return cardio;
    }

    public List<String> getStretches() {
        return stretches;
    }
}
