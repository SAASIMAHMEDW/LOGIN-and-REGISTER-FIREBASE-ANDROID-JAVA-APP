package com.example.firebaseauthbyemailpasswordx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button goBTNMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goBTNMain = findViewById(R.id.goBTNMain);
        goBTNMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg = new Intent(MainActivity.this, registerActivity.class);
                startActivity(reg);
            }
        });

    }
}