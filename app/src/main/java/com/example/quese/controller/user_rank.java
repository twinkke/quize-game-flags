package com.example.quese.controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.quese.R;
import com.example.quese.controller.RecyclerAdapter;
import com.example.quese.models.User_fire;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;


public class user_rank extends Fragment {
    RecyclerView recyclerView;

    ArrayList<User_fire> states = new ArrayList<>();
//    private ArrayList<User_fire> user_fires = new ArrayList<>();
    public DatabaseReference myData;
    int s = 0;
    String User_fire = "User_fire";
    RecyclerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_rank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        setInitialData();
        RecyclerView recyclerView = getView().findViewById(R.id.list);
        // создаем адаптер
        adapter = new RecyclerAdapter(getActivity().getApplicationContext(), states);
//        myData = FirebaseDatabase.getInstance().getReference("User_fire");
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
        setInitialData();
    }

    private void setInitialData() {

//        myData.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                User_fire storage = snapshot.getValue(User_fire.class);
//                states.add(new User_fire(storage.getName(), storage.getScore()));
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        //states.add(new User_fire (User_fire 1);
//        myData.orderByChild("score").addChildEventListener(new ChildEventListener){}
        FirebaseStorage storage = FirebaseStorage.getInstance();
        myData = FirebaseDatabase.getInstance().getReference(User_fire);

        ValueEventListener vel = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()) {
                    User_fire storage = ds.getValue(User_fire.class);
                    states.add(new User_fire(storage.getName(), storage.getScore()));
                }
               //ma->ur->xml<-adapter
                //ur->adapter
                //2s ->ur->adapterUpdate<-data

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        myData.addValueEventListener(vel);

    }
}