package com.example.firebaseauthbyemailpasswordx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class loginSuccesssFailActivity extends AppCompatActivity {


    boolean status;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_successs_fail);

        ImageView image = findViewById(R.id.SFImageView);
        TextView loginSFTV = findViewById(R.id.loginSFTV);

        Intent intent = getIntent();
        status = intent.getBooleanExtra("STATUS",false);

        if (status){
            image.setImageResource(R.drawable.success);
            loginSFTV.setText("Successful");
        }else {
            image.setImageResource(R.drawable.fail);
            loginSFTV.setText("Failed");
        }
    }
}