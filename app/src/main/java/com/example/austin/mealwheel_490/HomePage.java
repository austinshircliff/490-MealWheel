package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_selection_list_frag);

//
//        Button logoutBtn = (Button) findViewById(R.id.logout);
//
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                FacebookSdk.sdkInitialize(getApplicationContext());
//                LoginManager.getInstance().logOut();
//                restart();
//
//            }
//        });
    }

    public void restart()
    {
        Intent intent = new Intent(this, FacebookLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();

    }
}
