package com.example.austin.mealwheel_490;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class SpinnerActivity extends AppCompatActivity {

    ImageView arrow;
    Button spinbtn;
    Random spin = new Random();
    int randomspin;
    TextView text;
    Boolean restart = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        arrow = (ImageView) findViewById(R.id.arrowimage);
        spinbtn = (Button) findViewById(R.id.spinButton);


        spinbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Spin();
            }

        });


    }

    public void Spin() {
        if (restart) {
            randomspin = spin.nextInt() + 360;
            RotateAnimation rotatearrow = new RotateAnimation(0, randomspin,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            rotatearrow.setFillAfter(true);
            rotatearrow.setDuration(1500);
            rotatearrow.setInterpolator(new AccelerateDecelerateInterpolator());

            arrow.startAnimation(rotatearrow);

            restart = false;


        } else {
            randomspin = spin.nextInt() + 360;
            RotateAnimation rotatearrow = new RotateAnimation(0, randomspin,
                    RotateAnimation.RELATIVE_TO_SELF, 0.5f, RotateAnimation.RELATIVE_TO_SELF, 0.5f);
            rotatearrow.setFillAfter(true);
            rotatearrow.setDuration(1000);
            rotatearrow.setInterpolator(new AccelerateDecelerateInterpolator());

            arrow.startAnimation(rotatearrow);
            restart = true;
        }

    }

    public void Winner()
    {
        
    }
}

