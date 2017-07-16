package com.example.bwright.bodybuilder;

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
 * Created by bwrig on 7/15/2017.
 */

public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ViewHolder> {
    private List<String> list;

    public ExerciseAdapter(List<String> list) {
        this.list = list;
    }
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recycler_view_exercises, viewGroup, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final String name = list.get(i);
        viewHolder.textView.setText(name);
        viewHolder.imageView.setImageResource(R.drawable.ic_dumbell);
        viewHolder.button.setImageResource(R.drawable.ic_arrow_downward);
        viewHolder.button.setOnClickListener(new ImageView.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;
        private ImageButton button;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
            textView = (TextView) itemView.findViewById(R.id.this_exercise);
            button = (ImageButton) itemView.findViewById(R.id.imageButton);
        }
    }
}
