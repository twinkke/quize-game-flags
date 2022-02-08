package com.example.quese.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.quese.R;
import com.example.quese.controller.MainActivity;

public class fragment1 extends Fragment implements View.OnClickListener{
    Button btnStart;
    Button btnTop;
    Button btnExit;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment1_mai, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnStart = getView().findViewById(R.id.Start_btn);
        btnStart.setOnClickListener(this);
        btnTop = getView().findViewById(R.id.top);
        btnTop.setOnClickListener(this);
        btnExit = getView().findViewById(R.id.Exit_btn);
        btnExit.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Start_btn:
                ((MainActivity)getActivity()).fragmentChange(1);
                break;
            case R.id.top:
                ((MainActivity)getActivity()).fragmentChange(3);
                break;
            case R.id.Exit_btn:
                ((MainActivity) getActivity()).onBackPressed();
                break;

        }
    }




}















