package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.austin.mealwheel_490.model.Restaurants;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);



        if (AccessToken.getCurrentAccessToken() == null) {

            Button login_logout = (Button) findViewById(R.id.logout);
            login_logout.setText("Login");
        }


        Button logoutBtn = (Button) findViewById(R.id.logout);
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                FacebookSdk.sdkInitialize(getApplicationContext());
                LoginManager.getInstance().logOut();
                restart();

            }
        });

        Button playbtn = (Button)findViewById(R.id.playbutton);
        playbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,RestaurantSelectionActivity.class);
                startActivity(intent);
            }
        });







            Button addBtn = (Button) findViewById(R.id.addchoicesbutton);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (AccessToken.getCurrentAccessToken() == null) {

                        Toast.makeText(HomeActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                        toLogin();

                    } else if (AccessToken.getCurrentAccessToken() != null)
                    {
                        Intent intent = new Intent(HomeActivity.this, AddRestaurantActivity.class);
                        startActivity(intent);

                    }


                }
            });



        Button deletechoiceBtn = (Button) findViewById(R.id.deletebutton);
        deletechoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (AccessToken.getCurrentAccessToken() == null) {

                    Toast.makeText(HomeActivity.this, "Please Login", Toast.LENGTH_SHORT).show();
                    toLogin();

                } else if (AccessToken.getCurrentAccessToken() != null)
                {
                    Intent intent = new Intent(HomeActivity.this,DeleteChoiceActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void restart()
    {
        Intent intent = new Intent(this, FacebookLogin.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
       
    }
    public void toLogin()
    {
        Intent intent = new Intent(HomeActivity.this, FacebookLogin.class);
        startActivity(intent);
    }
}
