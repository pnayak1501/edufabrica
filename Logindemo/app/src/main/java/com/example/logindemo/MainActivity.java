package com.example.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        uname=findViewById(R.id.username);
        pas=findViewById(R.id.password);
    }

    public void login(View view) {
        if(uname.getText().toString.equals("prahlad")&&pas.getText().toString().equals("12345")) {
            Toast.makeText(this, "Login Successfool", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "Login Pailed", Toast.LENGTH_SHORT).show();
        }
    }
}
