package com.example.quese.controller;

import androidx.annotation.NonNull;

import com.example.quese.models.GameGenerator;
import com.example.quese.models.User_fire;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SenderFireBase {
    public DatabaseReference myData;
    String UserQuestion = "Question";
    ArrayList<GameGenerator> data = new ArrayList<GameGenerator>();
    User_fire uf;

    public SenderFireBase() {
        colectiondata();
        //funcDataQuestion();
    }

    public void colectiondata() {

        myData = FirebaseDatabase.getInstance().getReference(UserQuestion);
        ValueEventListener vel = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot ds : snapshot.getChildren()){

                    GameGenerator quese = ds.getValue(GameGenerator.class);
                    data.add(quese);
                    uf = quese.getAnswerFour();
                }
                //?image
                GameGenerator data1;
                data1 = data.get(0);
                User_fire answer1 = data1.getAnswerOne();
                User_fire answer2 = data1.getAnswerTwo();
                User_fire answer3 = data1.getAnswerThree();
                User_fire answer4 = data1.getAnswerFour();
                System.out.println(data1.getGameNamber());
                System.out.println(answer1.getName());
                System.out.println(answer2.getName());
                System.out.println(answer3.getName());
                System.out.println(answer4.getName());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        myData.addValueEventListener(vel);

    }

    // put in the firebase
    public void  funcDataQuestion(){
        myData = FirebaseDatabase.getInstance().getReference(UserQuestion);

        User_fire answer1 = new User_fire("Япония", "false");
        User_fire answer2 = new User_fire("Абхазия", "true");
        User_fire answer3 = new User_fire("Швейцария", "false");
        User_fire answer4 = new User_fire("Ангола", "false");
        GameGenerator gameer = new GameGenerator("tenth","image_question/abhazia.jpg",answer1,answer2,answer3,answer4);
        myData.push().setValue(gameer);
    }
}
