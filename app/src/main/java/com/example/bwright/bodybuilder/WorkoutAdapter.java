package com.example.bwright.bodybuilder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by bwrig on 7/14/2017.
 */

public class WorkoutAdapter extends RecyclerView.Adapter<WorkoutAdapter.ViewHolder> {
    private List<String> mItems;
    private Activity context;

    public WorkoutAdapter(Activity context, List<String> mItems) {
        this.context = context;
        this.mItems = mItems;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_card_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int index) {
        final String name = mItems.get(index);
        viewHolder.name.setText(name);
        viewHolder.img.setImageResource(R.drawable.ic_dumbell);
        viewHolder.button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                switch (index) {
                    case 0:
                        intent = new Intent(context, LoadCoreExercises.class);
                        break;
                    case 1:
                        intent = new Intent(context, LoadLowerBodyExercises.class);
                        break;
                    case 2:
                        intent = new Intent(context, LoadChestExercises.class);
                        break;
                    case 3:
                        intent = new Intent(context, LoadShoulderExercises.class);
                        break;
                    case 4:
                        intent = new Intent(context, LoadBackExercises.class);
                        break;
                    case 5:
                        intent = new Intent(context, LoadArmExercises.class);
                        break;
                    case 6:
                        intent = new Intent(context, LoadCardioExercises.class);
                        break;
                    case 7:
                        intent = new Intent(context, LoadStretchExercises.class);
                        break;
                    default:
                        intent = null;
                        break;
                }
                if (intent != null) {
                    context.startActivity(intent);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name;
        private Button button25;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img_thumbnail);
            name = (TextView) itemView.findViewById(R.id.name);
            button25 = (Button) itemView.findViewById(R.id.button25);
        }
    }
}
