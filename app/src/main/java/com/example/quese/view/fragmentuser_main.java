package com.example.quese.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quese.R;
import com.example.quese.controller.MainActivity;
import com.example.quese.models.User_fire;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class fragmentuser_main extends Fragment implements View.OnClickListener {
    TextView btnscore;
    Button btnSave;
    Button btnExit;
    private EditText btnname;
    private ImageView btnicon;
    int mainscore;
    public DatabaseReference myData;
    String UserKey = "User_fire";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmentuser_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mainscore = ((MainActivity) getActivity()).getScore();
        btnscore = getView().findViewById(R.id.score);
        btnExit = getView().findViewById(R.id.exit);
        btnicon = getView().findViewById(R.id.profile_image);
        btnicon.setOnClickListener(this);
        btnExit.setOnClickListener(this);//  ((MainActivity) getActivity()).fragmentChange(2);
        btnSave = getView().findViewById(R.id.save);
        btnSave.setOnClickListener(this);
        btnname = getView().findViewById(R.id.name);

        btnscore.setText("Score  " + String.valueOf(mainscore));

        myData = FirebaseDatabase.getInstance().getReference(UserKey);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.save:

                //String icon = btnicon.getImageMatrix().toString();
                String name = btnname.getText().toString();
                String score = btnscore.getText().toString();

                User_fire new_user = new User_fire(name,score);


                if (!TextUtils.isEmpty(name)) {

                    myData.push().setValue(new_user);
                    Toast toast1 = Toast.makeText(getActivity().getApplicationContext(),
                            "Сохранено",
                            Toast.LENGTH_SHORT);
                  //  toast1.setGravity(Gravity.CENTER, 0, 0);// не работает
                    toast1.show();
                } else {
                    Toast toast2 = Toast.makeText(getActivity().getApplicationContext(),
                            "Пустое поле",
                            Toast.LENGTH_SHORT);
               //     toast2.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                    toast2.show();
                }

            case R.id.exit:
                ((MainActivity) getActivity()).fragmentChange(0);

            }

        }


}