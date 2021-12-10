package com.example.exercisemenelaoskotoglou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exercisemenelaoskotoglou.ui.login.LoginActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText email, password, repassword;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


    }

    public void signup(View v) {

        EditText email = findViewById(R.id.email);
        EditText password = findViewById(R.id.password);
        EditText repassword = findViewById(R.id.repassword);

        Button signup = findViewById(R.id.signup);
        Button signin = findViewById(R.id.signin);

        DBHelper DB = new DBHelper(this);

        String email_s = email.getText().toString();
        String password_s = password.getText().toString();
        String repassword_s = repassword.getText().toString();

        if (email_s.equals("") || password_s.equals("") || repassword_s.equals("")) {
            Toast.makeText(RegisterActivity.this, "Please enter your all fields", Toast.LENGTH_LONG).show();
        } else {
            if (password_s.equals(repassword_s)) {
                Boolean checkUser = DB.checkemail(email_s);
                if (checkUser == false) {
                    Boolean insert = DB.insertData(email_s, password_s);
                    if (insert == true) {
                        Toast.makeText(RegisterActivity.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(this, LoginActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(RegisterActivity.this, "Could not register user", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "User already exists, please sign in!", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(RegisterActivity.this, "Passwords do not match!", Toast.LENGTH_LONG).show();
            }
        }

    }

    public void signin(View v) {
        Intent in = new Intent(this, LoginActivity.class);
        startActivity(in);
    }
}