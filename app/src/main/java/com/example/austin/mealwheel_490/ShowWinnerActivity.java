package com.example.austin.mealwheel_490;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;

public class ShowWinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_winner);

        final String winner;
        TextView winnerTextView;
        winnerTextView = (TextView) findViewById(R.id.winner);
        CallbackManager callbackManager = CallbackManager.Factory.create();
        Bundle extras;
        Button shareOnFb;
        Button replay;
        extras = getIntent().getExtras();
        winner = extras.getString("winner");
        shareOnFb = (Button) findViewById(R.id.shareonfacebookbutton);
        replay = (Button) findViewById(R.id.Replay);

        winnerTextView.setText(winner);
        final ShareDialog shareDialog = new ShareDialog(this);



        shareDialog.registerCallback(callbackManager, new
                FacebookCallback<Sharer.Result>() {
                    @Override
                    public void onSuccess(Sharer.Result result) {

                    }

                    @Override
                    public void onCancel() {

                    }

                    @Override
                    public void onError(FacebookException error) {

                    }
                });
        shareOnFb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                if(ShareDialog.canShow(ShareLinkContent.class))
                {
                    ShareLinkContent linkContent = new ShareLinkContent.Builder()
                            .setContentTitle("Meal Wheel!").setContentDescription("After Using the Meal Wheel App, I have decided to go to " + winner+" !")
                            .setContentUrl(Uri.parse("http://developers.facebook.com/android"))
                            .build();

                    shareDialog.show(linkContent);
                }
            }
        });

        replay.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowWinnerActivity.this,HomeActivity.class);
                startActivity(intent);
            }
        });



    }
}
