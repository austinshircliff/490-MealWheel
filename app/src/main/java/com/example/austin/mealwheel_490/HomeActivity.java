package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        Button logoutBtn = (Button) findViewById(R.id.logout);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FacebookSdk.sdkInitialize(getApplicationContext());
                LoginManager.getInstance().logOut();
                restart();

            }
        });

        Button manageChoices = (Button)findViewById(R.id.managechoicesbutton);
        manageChoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,RestaurantActivity.class);
                startActivity(intent);
            }
        });

    }

    public void restart()
    {
        Intent intent = new Intent(this, FacebookLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        Toast.makeText(this, "Logged Out", Toast.LENGTH_SHORT).show();





    }
}
