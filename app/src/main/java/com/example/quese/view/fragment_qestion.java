package com.example.quese.view;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.quese.R;
import com.example.quese.controller.MainActivity;
import com.example.quese.models.GameGenerator;
import com.example.quese.models.User_fire;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;


public class fragment_qestion extends  Fragment implements View.OnClickListener {

    public DatabaseReference myData;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ImageView image;
    int s = 0;
    Handler handler = new Handler();
    int rightAnswer;
    int btnClicked = 0;
    int numberOfRigigtAnswer = 0;

    String imageURL = "https://firebasestorage.googleapis.com/v0/b/dataquese.appspot.com/o/image_question%2F%D0%9D%D0%BE%D1%80%D0%B2%D0%B5%D0%B3%D0%B8%D1%8F.jpg?alt=media&token=ba7d3d2b-03f3-4134-820c-5b0809c40ce4";
    String UserQuestion = "Question";
    ArrayList<GameGenerator> data = new ArrayList<GameGenerator>();
    User_fire uf;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_guetion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        button1 = getView().findViewById(R.id.Button1);
        button2 = getView().findViewById(R.id.Button2);
        button3 = getView().findViewById(R.id.Button3);
        button4 = getView().findViewById(R.id.Button4);
        image = getView().findViewById(R.id.image);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        setGame(s);
    }

        private void setGame(int s) {

            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference httpsReference = storage.getReferenceFromUrl(imageURL);
            myData = FirebaseDatabase.getInstance().getReference(UserQuestion);

            ValueEventListener vel = new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot ds : snapshot.getChildren()) {
                        GameGenerator storage = ds.getValue(GameGenerator.class);
                        data.add(storage);
                    }

                    GameGenerator data1;
                    data1 = data.get(s);
                    String image = data1.getImage();
                    User_fire answer1 = data1.getAnswerOne();
                    User_fire answer2 = data1.getAnswerTwo();
                    User_fire answer3 = data1.getAnswerThree();
                    User_fire answer4 = data1.getAnswerFour();
                    GameLoader(image,answer1,answer2,answer3,answer4);
                    loading(image);
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    return;
                }


            };
            myData.addValueEventListener(vel);
            //System.out.println(String.valueOf(uf.getName()));
          }


        private void loading(String zaebca){
            FirebaseStorage storage = FirebaseStorage.getInstance();
            StorageReference storageRef = storage.getReference();
            StorageReference islandRef = storageRef.child(zaebca);


            final long ONE_MEGABYTE = 1024 * 1024;
            islandRef.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
                @Override
                public void onSuccess(byte[] bytes) {
                   // System.out.println(bytes);
                    Bitmap bmp = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                    image.setImageBitmap(bmp);
                                    }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception exception) {
                    // Handle any errors
                }
            });


        }

        private  void GameLoader(String image,User_fire answer1, User_fire answer2, User_fire answer3, User_fire answer4){

          //  StorageReference storageReference = FirebaseStorage.getInstance().getReference(UserQuestion);
            button1.setBackgroundColor(Color.parseColor("#EAE62F"));
            button2.setBackgroundColor(Color.parseColor("#EAE62F"));
            button3.setBackgroundColor(Color.parseColor("#EAE62F"));
            button4.setBackgroundColor(Color.parseColor("#EAE62F"));

            button1.setText(answer1.getName());
            button1.setTag(answer1.getScore());
            button2.setText(answer2.getName());
            button2.setTag(answer2.getScore());
            button3.setText(answer3.getName());
            button3.setTag(answer3.getScore());
            button4.setText(answer4.getName());
            button4.setTag(answer4.getScore());

        }
/*

    public void setQuese (int num){
        Question image1 = new Question(R.drawable.abhazia,"Япония", "Абхазия","Палестина","Иран",2);
        Question image2 = new Question(R.drawable.norvegia,"Пакистан", "Норвегия","Палестина","Ирак",2);
        Question image3 = new Question(R.drawable.japanice,"Япония", "Египет","Палестина","Румыния",1);
        Question image4 = new Question(R.drawable.palestina,"Япония", "Норвегия","Палестина","Иран",3);
        Question image5 = new Question(R.drawable.iran,"Япония", "Норвегия","Палестина","Иран",4);
        Question image6 = new Question(R.drawable.bangladesh,"Бангладеш", "Норвегия","Япония","Иран",1);
        Question image7 = new Question(R.drawable.bahrein,"Япония", "Норвегия","Палестина","Бахрейн",4);
        Question image8 = new Question(R.drawable.zimbabve,"Япония", "Норвегия","Зимбабве","Иран",3);
        Question image9 = new Question(R.drawable.germany,"Бразилия", "Норвегия","Германия","Иран",3);
        Question image10 = new Question(R.drawable.canad,"Ангола", "Канада","Палестина","Иран",2);


        button1.setBackgroundColor(Color.parseColor("#EAE62F"));
        button2.setBackgroundColor(Color.parseColor("#EAE62F"));
        button3.setBackgroundColor(Color.parseColor("#EAE62F"));
        button4.setBackgroundColor(Color.parseColor("#EAE62F"));

        switch (num){
            case 0:
                image.setImageResource(image1.getImage());
                button1.setText(image1.getBtn1());
                button2.setText(image1.getBtn2());
                button3.setText(image1.getBtn3());
                button4.setText(image1.getBtn4());
                rightAnswer = (image1.getAnswer());
                break;
            case 1:
                image.setImageResource(image2.getImage());
                button1.setText(image2.getBtn1());
                button2.setText(image2.getBtn2());
                button3.setText(image2.getBtn3());
                button4.setText(image2.getBtn4());
                rightAnswer = (image2.getAnswer());
                break;
            case 2:
                image.setImageResource(image3.getImage());
                button1.setText(image3.getBtn1());
                button2.setText(image3.getBtn2());
                button3.setText(image3.getBtn3());
                button4.setText(image3.getBtn4());
                rightAnswer = (image3.getAnswer());
                break;
            case 3:
                image.setImageResource(image4.getImage());
                button1.setText(image4.getBtn1());
                button2.setText(image4.getBtn2());
                button3.setText(image4.getBtn3());
                button4.setText(image4.getBtn4());
                rightAnswer = (image4.getAnswer());
                break;
            case 4:
                image.setImageResource(image5.getImage());
                button1.setText(image5.getBtn1());
                button2.setText(image5.getBtn2());
                button3.setText(image5.getBtn3());
                button4.setText(image5.getBtn4());
                rightAnswer = (image5.getAnswer());
                break;
            case 5:
                image.setImageResource(image6.getImage());
                button1.setText(image6.getBtn1());
                button2.setText(image6.getBtn2());
                button3.setText(image6.getBtn3());
                button4.setText(image6.getBtn4());
                rightAnswer = (image6.getAnswer());
                break;
            case 6:
                image.setImageResource(image7.getImage());
                button1.setText(image7.getBtn1());
                button2.setText(image7.getBtn2());
                button3.setText(image7.getBtn3());
                button4.setText(image7.getBtn4());
                rightAnswer = (image7.getAnswer());
                break;
            case 7:
                image.setImageResource(image8.getImage());
                button1.setText(image8.getBtn1());
                button2.setText(image8.getBtn2());
                button3.setText(image8.getBtn3());
                button4.setText(image8.getBtn4());
                rightAnswer = (image8.getAnswer());
                break;
            case 8:
                image.setImageResource(image9.getImage());
                button1.setText(image9.getBtn1());
                button2.setText(image9.getBtn2());
                button3.setText(image9.getBtn3());
                button4.setText(image9.getBtn4());
                rightAnswer = (image9.getAnswer());
                break;
            case 9:
                image.setImageResource(image10.getImage());
                button1.setText(image10.getBtn1());
                button2.setText(image10.getBtn2());
                button3.setText(image10.getBtn3());
                button4.setText(image10.getBtn4());
                rightAnswer = (image10.getAnswer());
                break;
            default:
                s=1;
        }

        s+= 1;
    }
*/
    @Override
    public void onClick(View view) {
        s += 1;
        System.out.println(view.getTag());

        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);

        handler.postDelayed(new Runnable() {
            public void run() {
                setGame(s);
                button1.setClickable(true);
                button2.setClickable(true);
                button3.setClickable(true);
                button4.setClickable(true);
                // действие будет выполнено через 2с
            }
        }, 500);

        if (view.getTag().equals("true")){
            view.setBackgroundColor(Color.parseColor("#FF018786"));
           // System.out.println("good");
            numberOfRigigtAnswer += 1;
        }
        if (view.getTag().equals("false")){
            view.setBackgroundColor(Color.parseColor("#C55643"));
           // System.out.println("bad");
        }
/*
        switch (view.getId()) {
            case R.id.Button1:
                btnClicked = 1;
                button1.setBackgroundColor(Color.parseColor("#C55643"));
                break;

            case R.id.Button2:
                btnClicked = 2;
                button2.setBackgroundColor(Color.parseColor("#C55643"));
                break;

            case R.id.Button3:
                btnClicked = 3;
                button3.setBackgroundColor(Color.parseColor("#C55643"));
                break;

            case R.id.Button4:
                btnClicked = 4;
                button4.setBackgroundColor(Color.parseColor("#C55643"));
                break;

        }*/

       if (s >= 10){
           ((MainActivity) getActivity()).scoreSet(numberOfRigigtAnswer);
           ((MainActivity) getActivity()).setScore(numberOfRigigtAnswer);
           ((MainActivity) getActivity()).fragmentChange(2);
       }

//        showingAnswer();
    }

//    private void showingAnswer() {
//
//        switch (rightAnswer) {
//            case 1:
//                button1.setBackgroundColor(Color.parseColor("#FF018786"));
//                break;
//            case 2:
//                button2.setBackgroundColor(Color.parseColor("#FF018786"));
//                break;
//            case 3:
//                button3.setBackgroundColor(Color.parseColor("#FF018786"));
//                break;
//            case 4:
//                button4.setBackgroundColor(Color.parseColor("#FF018786"));
//                break;
//        }
//
//        handler.postDelayed(new Runnable() {
//            public void run() {
//                setGame(s);
//                button1.setClickable(true);
//                button2.setClickable(true);
//                button3.setClickable(true);
//                button4.setClickable(true);
//                // действие будет выполнено через 2с
//            }
//        }, 500);
//
//
//    }

}


















