package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {

    ImageView arrow;
    Button spinbtn;
    Random spin = new Random();
    int randomspin;
    Boolean restart = false;
    ArrayList<String> restselected;
    TextView rest1;
    TextView rest2;
    TextView rest3;
    TextView rest4;
    TextView rest5;
    TextView rest6;
    float logspin;
    String logspin2;
    String lograndom;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        arrow = (ImageView) findViewById(R.id.arrowimage);
        spinbtn = (Button) findViewById(R.id.spinButton);
        rest1 = (TextView) findViewById(R.id.option1textView);
        rest2 = (TextView) findViewById(R.id.option2textView);
        rest3 = (TextView) findViewById(R.id.option3textView);
        rest4 = (TextView) findViewById(R.id.option4textView);
        rest5 = (TextView) findViewById(R.id.option5textView);
        rest6 = (TextView) findViewById(R.id.option6textView);


        restselected = getIntent().getStringArrayListExtra("listofselecteditems");

        SetChoices();



        spinbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Spin();
                Winner();

            }

        });

    }

    public void Spin() {
        if (restart) {
            randomspin = spin.nextInt();
//

            arrow.animate().rotation(randomspin);


            restart = false;


        } else {
            randomspin = spin.nextInt();

            arrow.animate().rotation(randomspin);

            restart = true;
        }

        logspin = arrow.getRotation();
        logspin2 = String.valueOf(logspin);
        Log.d("spin",logspin2);
        lograndom = String.valueOf(randomspin);
        Log.d("randomspin",lograndom);
    }

    public void Winner()
    {

        if( arrow.getRotation() <= 60 & arrow.getRotation() >=  0)
        Toast.makeText(this, rest1.getText(), Toast.LENGTH_SHORT).show();
        else if(arrow.getRotation() > 61 & arrow.getRotation() <= 120 ){
            Toast.makeText(this, rest2.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(arrow.getRotation() > 121 & arrow.getRotation() <= 180 ){
            Toast.makeText(this, rest3.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(arrow.getRotation() > 181 & arrow.getRotation() <= 240){
            Toast.makeText(this, rest4.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(arrow.getRotation() > 241 & arrow.getRotation() <= 300 ){
            Toast.makeText(this, rest5.getText(), Toast.LENGTH_SHORT).show();
        }
        else if(arrow.getRotation() > 301 ){
            Toast.makeText(this, rest6.getText(), Toast.LENGTH_SHORT).show();
        }

    }
    public void SetChoices()
    {
        if(restselected.size() == 0)
        {
            clearSelections();
            Toast.makeText(this, "Please Select Up to 6 Choices", Toast.LENGTH_SHORT).show();
        }
        else if(restselected.size() == 1)
        {
            clearSelections();
            Toast.makeText(this, "Please Select More Than One", Toast.LENGTH_SHORT).show();
        }
        else if (restselected.size() == 2)
        {
            rest1.setText(restselected.get(0));
            rest2.setText(restselected.get(1));
            rest3.setText(restselected.get(0));
            rest4.setText(restselected.get(1));
            rest5.setText(restselected.get(0));
            rest6.setText(restselected.get(1));
        }
        else if(restselected.size() == 3)
        {
            rest1.setText(restselected.get(0));
            rest2.setText(restselected.get(1));
            rest3.setText(restselected.get(2));
            rest4.setText(restselected.get(0));
            rest5.setText(restselected.get(1));
            rest6.setText(restselected.get(2));
        }
        else if (restselected.size() == 4)
        {
            rest1.setText(restselected.get(0));
            rest2.setText(restselected.get(1));
            rest3.setText(restselected.get(2));
            rest4.setText(restselected.get(3));
            rest5.setText(restselected.get(0));
            rest6.setText(restselected.get(1));
        }
        else if(restselected.size() == 5)
        {
            rest1.setText(restselected.get(0));
            rest2.setText(restselected.get(1));
            rest3.setText(restselected.get(2));
            rest4.setText(restselected.get(3));
            rest5.setText(restselected.get(4));
            rest6.setText(restselected.get(2));
        }
        else if(restselected.size() == 6) {

            rest1.setText(restselected.get(0));
            rest2.setText(restselected.get(1));
            rest3.setText(restselected.get(2));
            rest4.setText(restselected.get(3));
            rest5.setText(restselected.get(4));
            rest6.setText(restselected.get(5));
        }
        else
        {
            clearSelections();
            Toast.makeText(this, "Please Select No More Than 6", Toast.LENGTH_SHORT).show();

        }
    }
    public void clearSelections()
    {
        Intent intent = new Intent(this,HomeActivity.class);
        startActivity(intent);
    }
}

