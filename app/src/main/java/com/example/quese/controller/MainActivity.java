package com.example.quese.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.quese.R;
import com.example.quese.view.fragment1;
import com.example.quese.view.fragment_qestion;
import com.example.quese.view.fragmentuser_main;

import java.net.URI;

public class MainActivity extends AppCompatActivity{
    public int rightAnswer;
    URI uri;
    private long onHiddenTime;
    private Toast bakeToast;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new SenderFireBase();
        fragmentChange(0);

    }
    // интерфейс fragmentChange default, здесь описать и implements, Attach(), Detach()
       public void fragmentChange (int i) {
           Fragment fragment;
           switch (i){
               case 1:
                   fragment = new fragment_qestion();
                   break;
               case 2:
                   fragment = new fragmentuser_main();
                   break;
               case 3:
                   fragment = new user_rank();
                   break;
               default:
                   fragment = new fragment1();
                   break;
           }

           FragmentManager fm = getSupportFragmentManager();
           FragmentTransaction ft = fm.beginTransaction();
           ft.replace(R.id.fragment_main, fragment);
           ft.commit();
       }

    public void scoreSet (int numtrue){
        score = numtrue;
       }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    //выход из приложения по двойному щелчку
    @Override
    public void onBackPressed() {

            if (onHiddenTime + 2000 > System.currentTimeMillis()){
                bakeToast.cancel();
                super.onBackPressed();
                return;
            } else {
                bakeToast = Toast.makeText(getBaseContext(), "Click double", Toast.LENGTH_SHORT);
                bakeToast.show();
                fragmentChange(0);
            }
            onHiddenTime = System.currentTimeMillis();
    }









    /*
     Question image1 = new Question(R.drawable.abhazia,"Япония", "Абхазия","Палестина","Иран",2);
      listArray<GameGenerator> = myData.push().setValue(gameer)
      listArray.append()
      GameGenerator game = listArray[3]
      User_fire answer1 = game.answer1
      onBtnClick(){
      if answer1.score == "true"{
      code
      }
    }


     */

}