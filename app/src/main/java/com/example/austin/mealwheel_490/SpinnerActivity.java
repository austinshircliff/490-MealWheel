package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.os.Handler;
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
import java.util.Timer;


public class SpinnerActivity extends AppCompatActivity {

    ImageView arrow;
    Button spinbtn;
    Random spin = new Random();
    int randomspin;
    ArrayList<String> restselected;
    TextView rest1;
    TextView rest2;
    TextView rest3;
    TextView rest4;
    TextView rest5;
    TextView rest6;
    float randomAngleDegrees;
    String winningRest;




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

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(SpinnerActivity.this, ShowWinnerActivity.class);
                        intent.putExtra("winner",winningRest);
                        startActivity(intent);

                    }
                }, 2000);

            }


        });


    }


    public void Spin() {

        randomAngleDegrees = (float) Math.toDegrees(Math.random()*2 * Math.PI) + 80000;


        arrow.animate().setDuration(2000).rotation(randomAngleDegrees);

    }

    public void Winner()
    {

        if(  (randomAngleDegrees/2) - 40000 < 30 & (randomAngleDegrees/2) -40000 >  0)
            winningRest = rest2.getText().toString();

        else if((randomAngleDegrees/2)- 40000 > 31 & (randomAngleDegrees/2)- 40000 < 60 ){
            winningRest = rest3.getText().toString();
        }
        else if((randomAngleDegrees/2) - 40000 > 61 & (randomAngleDegrees/2) - 40000 < 90 ){
            winningRest = rest4.getText().toString();
        }
        else if((randomAngleDegrees/2) - 40000 > 91 & (randomAngleDegrees/2) - 40000 < 120){
            winningRest = rest5.getText().toString();
        }
        else if((randomAngleDegrees/2) - 40000 > 121 & (randomAngleDegrees/2)  - 40000 < 150 ){
            winningRest = rest6.getText().toString();
        }
        else if((randomAngleDegrees/2) - 40000 > 151 ){
            winningRest = rest1.getText().toString();
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

