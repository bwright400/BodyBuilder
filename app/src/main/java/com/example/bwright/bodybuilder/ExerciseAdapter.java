package com.example.bwright.bodybuilder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by bwrig on 7/15/2017.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private List<String> list;
    private String[][] workoutStats = new String[6][4];
    private Map<String, String> map = new HashMap<>();
    private String update;

    public ExerciseAdapter(List<String> list) {
        this.list = list;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.add_data, viewGroup, false);
        intialize();
        return new ViewHolder(view);

    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView, sets, reps, weight, title;
        private ImageButton imgOne, imgTwo, imgThree, imgFour, imgFive, imgSix, imgSeven;
        private Button button;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);


            imageView = (ImageView) itemView.findViewById(R.id.img);
            textView = (TextView) itemView.findViewById(R.id.that_exercise);
            button = (Button) itemView.findViewById(R.id.submit);
            cardView = (CardView) itemView.findViewById(R.id.main);

            imgOne = (ImageButton) itemView.findViewById(R.id.img1);
            imgTwo = (ImageButton) itemView.findViewById(R.id.img2);
            imgThree = (ImageButton) itemView.findViewById(R.id.img3);
            imgFour = (ImageButton) itemView.findViewById(R.id.img4);
            imgFive = (ImageButton) itemView.findViewById(R.id.img5);
            imgSix = (ImageButton) itemView.findViewById(R.id.img6);

            title = (TextView) itemView.findViewById(R.id.type);
            sets = (TextView) itemView.findViewById(R.id.sets);
            reps = (TextView) itemView.findViewById(R.id.reps);
            weight = (TextView) itemView.findViewById(R.id.weight);

        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    private void addImageResources(final ViewHolder viewHolder) {
        viewHolder.imageView.setImageResource(R.drawable.ic_dumbell);
        viewHolder.imgOne.setImageResource(R.drawable.ic_minus);
        viewHolder.imgTwo.setImageResource(R.drawable.ic_plus);
        viewHolder.imgThree.setImageResource(R.drawable.ic_minus);
        viewHolder.imgFour.setImageResource(R.drawable.ic_plus);
        viewHolder.imgFive.setImageResource(R.drawable.ic_minus);
        viewHolder.imgSix.setImageResource(R.drawable.ic_plus);

    }

    public String increment(String string) {
        String array[] = string.split(" ");

        if (Integer.parseInt(array[0]) != 0) {
            int x = Integer.parseInt(array[0]);
            array[0] = Integer.toString(++x);
        }
        else if (Integer.parseInt(array[0]) == 0) {
            array[0] = Integer.toString(1);
        }

        string = array[0] + " " + array[1];

        return string;
    }

    public String decrement(String string) {
        String array[] = string.split(" ");

        if (Integer.parseInt(array[0]) != 0) {
            int x = Integer.parseInt(array[0]);
            array[0] = Integer.toString(--x);
        }

        string = array[0] + " " + array[1];

        return string;
    }

    public void intialize() {
        for (int i = 0; i < 5; i++) {
            workoutStats[i][1] = "0 Sets";
            workoutStats[i][2] = "0 Reps";
            workoutStats[i][3] = "0 Weight";
        }

    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        workoutStats[viewHolder.getAdapterPosition()][0] = list.get(viewHolder.getAdapterPosition());
        if (viewHolder.getAdapterPosition() == 0) {
            //viewHolder.title.setText(workoutStats[position][0]);
            viewHolder.title.setTextSize(15);
        }
        else {
            viewHolder.title.setVisibility(View.GONE);
        }

        if (viewHolder.getAdapterPosition() < 5) {
            viewHolder.textView.setText(workoutStats[viewHolder.getAdapterPosition()][0]);
            viewHolder.textView.setTextSize(15);

            addImageResources(viewHolder);

            // add all the onclicklistners
            viewHolder.imgOne.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.sets.setText(decrement(viewHolder.sets.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][1] = viewHolder.sets.getText().toString();
                }
            });
            viewHolder.imgTwo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.sets.setText(increment(viewHolder.sets.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][1] = viewHolder.sets.getText().toString();
                }
            });
            viewHolder.imgThree.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.reps.setText(decrement(viewHolder.reps.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][2] = viewHolder.reps.getText().toString();
                }
            });
            viewHolder.imgFour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.reps.setText(increment(viewHolder.reps.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][2] = viewHolder.reps.getText().toString();
                }
            });
            viewHolder.imgFive.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.weight.setText(decrement(viewHolder.weight.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][3] = viewHolder.weight.getText().toString();
                }
            });
            viewHolder.imgSix.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    viewHolder.weight.setText(increment(viewHolder.weight.getText().toString()));
                    workoutStats[viewHolder.getAdapterPosition()][3] = viewHolder.weight.getText().toString();
                }
            });
            viewHolder.button.setVisibility(View.GONE);

        } else {
            viewHolder.cardView.setVisibility(View.GONE);
            viewHolder.button.setVisibility(View.VISIBLE);
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendToFirebase();
                }
            });
        }

    }

    // get all the workout results
    public HashMap<String, Object> mapResults(int position) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("Sets", workoutStats[position][1]);
        map.put("Reps", workoutStats[position][2]);
        map.put("Weight", workoutStats[position][3]);
        return map;
    }

    // get the workout name with the workout results
    public HashMap<String, Object> mapWorkout() {
        HashMap<String, Object> map = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            map.put(workoutStats[i][0], mapResults(i));
        }
        return map;
    }

    // get the date the workout was done
    public HashMap workoutDate() {
        HashMap<String, Object> map = new HashMap<>();
        Date date = new Date();
        map.put("Date: " + date.toString(), mapWorkout());
        return map;
    }



    private void sendToFirebase() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("users");

        HashMap<String, Object> map = new HashMap<>();
        Date date = new Date();

 //       map.put(date.toString(), mapWorkout());
        //myRef.updateChildren(map);
        map.put("Date: " + date.toString(), mapWorkout());
//
        myRef.child(mAuth.getCurrentUser().getUid()).child("Workout History").updateChildren(map);
    }



}

//    private void setTheOnClickListeners(final ViewHolder viewHolder, String[][] workoutStats, final int position) {
//        viewHolder.imgOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.sets.setText(decrement(viewHolder.sets.getText().toString()));
//                workoutStats[position - 1][0] = viewHolder.sets.getText().toString();
//            }
//        });
//        viewHolder.imgTwo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.sets.setText(increment(viewHolder.sets.getText().toString()));
//                workoutStats[position - 1][0] = viewHolder.sets.getText().toString();
//            }
//        });
//        viewHolder.imgThree.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.reps.setText(decrement(viewHolder.reps.getText().toString()));
//                workoutStats[position - 1][1] = viewHolder.reps.getText().toString();
//            }
//        });
//        viewHolder.imgFour.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.reps.setText(increment(viewHolder.reps.getText().toString()));
//                workoutStats[position - 1][1] = viewHolder.reps.getText().toString();
//            }
//        });
//        viewHolder.imgFive.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.weight.setText(decrement(viewHolder.weight.getText().toString()));
//                workoutStats[position - 1][2] = viewHolder.weight.getText().toString();
//            }
//        });
//        viewHolder.imgSix.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                viewHolder.weight.setText(increment(viewHolder.weight.getText().toString()));
//                workoutStats[position - 1][2] = viewHolder.weight.getText().toString();
//            }
//        });
//    }
