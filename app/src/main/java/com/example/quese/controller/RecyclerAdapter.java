package com.example.quese.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.quese.R;
import com.example.quese.models.User_fire;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<User_fire> states;

    RecyclerAdapter(Context context, List<User_fire> states) {
        this.states = states;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recycle_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        User_fire state = states.get(position);
        //holder.flagView.setImageResource(state.getFlagResource());
        holder.nameView.setText(state.getName());
//        String result = Integer.toString(state.getScore());
        holder.capitalView.setText(state.getScore());
    }

    @Override
    public int getItemCount() {
        return states.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView nameView, capitalView;
        ViewHolder(View view){
            super(view);

            nameView = view.findViewById(R.id.label_name);
            capitalView = view.findViewById(R.id.label_score);
        }
    }
}