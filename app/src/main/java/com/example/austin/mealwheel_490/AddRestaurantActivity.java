package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.austin.mealwheel_490.model.Restaurants;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Random;

public class AddRestaurantActivity extends AppCompatActivity {

    private EditText newRestaurant;
    private Button addBtn;
    private Button homeBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant);


        DatabaseReference mRootRef = FirebaseDatabase.getInstance().getReference();
        final DatabaseReference mRestReference = mRootRef.child("restaurants");

        newRestaurant = (EditText) findViewById(R.id.addrestauranttext);
        addBtn = (Button) findViewById(R.id.addrestaurantBtn);
        homeBtn = (Button) findViewById(R.id.HomeButton);

        homeBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddRestaurantActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newRestaurantName = newRestaurant.getText().toString();


                mRestReference.child(newRestaurantName).child("name").setValue(newRestaurantName);
                newRestaurant.setText("");
            }
        });



















    }
}
