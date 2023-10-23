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

public class loginActivity extends AppCompatActivity {
    String email,password;
    Button loginBTN;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBTN = findViewById(R.id.loginBTN);
        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginBtn();
                Login(email,password);
            }
        });
    }

    public void  handleLoginBtn(){
        EditText emailETV,passwordETV;
        emailETV = findViewById(R.id.emailLoginETV);
        passwordETV = findViewById(R.id.passwordLoginETV);
        email = emailETV.getText().toString();
        password = passwordETV.getText().toString();
    }

    public void Login(String email,String password){
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
//                            Toast.makeText(loginActivity.this, "successs Auth", Toast.LENGTH_SHORT).show();
                            loginToSuccessAndFail(true);
                        }else {
//                            Toast.makeText(loginActivity.this, "fail Auth", Toast.LENGTH_SHORT).show();
                            loginToSuccessAndFail(false);
                        }
                    }
                });
    }

    public void loginToSuccessAndFail(boolean status){
        Intent successFail = new Intent(loginActivity.this,loginSuccesssFailActivity.class);
        successFail.putExtra("STATUS",status);
        startActivity(successFail);
    }
}