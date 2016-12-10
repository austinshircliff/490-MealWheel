package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);


        if (AccessToken.getCurrentAccessToken() == null) {

            Toast.makeText(this, "You are Not Currently Logged In", Toast.LENGTH_SHORT).show();
            goToLogin();

        } else if (AccessToken.getCurrentAccessToken() != null)
        {
            Toast.makeText(this,"You are logged in" ,Toast.LENGTH_LONG).show();

        }

        Button logoutbtn = (Button) findViewById(R.id.logout);
        gotoHome();

    }


    private void goToLogin() {

        Intent intent = new Intent(this, FacebookLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);


    }
    public void gotoHome()
    {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(this, "Welcome to Meal Wheel!", Toast.LENGTH_SHORT).show();

    }

}