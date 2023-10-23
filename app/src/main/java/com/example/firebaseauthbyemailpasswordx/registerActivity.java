package com.example.firebaseauthbyemailpasswordx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class registerActivity extends AppCompatActivity {


    Button regBTN;

    String email,password;



    private FirebaseAuth mAuth;
    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regBTN = findViewById(R.id.regBTN);
        regBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegBtn();
                Register(email,password);
            }
        });

    }

    public void handleRegBtn(){
        EditText regPassword,regEmail;
        regEmail = findViewById(R.id.regEmail);
        regPassword = findViewById(R.id.regPassword);
        email = regEmail.getText().toString();
        password = regPassword.getText().toString();

    }
    public void Register(String email,String password){

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseDatabase.getInstance();

        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(registerActivity.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
//                    FirebaseUser user = mAuth.getCurrentUser();
                    registerToLogin();
//                    Toast.makeText(registerActivity.this, user.getEmail(), Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(registerActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registerToLogin(){
        Intent loginIntent = new Intent(registerActivity.this,loginActivity.class);
        startActivity(loginIntent);

    }
}
