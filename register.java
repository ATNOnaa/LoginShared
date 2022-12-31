package com.example.tugaspemrogramanmobile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText nim, username, password;
    Button register, cancel;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nim = findViewById(R.id.nim);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        register = findViewById(R.id.registrasi);
        cancel = findViewById(R.id.cancel);

        preferences = getSharedPreferences("Userinfo", 0);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nimValue = nim.getText().toString();
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                if (usernameValue.length()>1){
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("Nim", nimValue);
                    editor.putString("Username", usernameValue);
                    editor.putString("Password", passwordValue);
                    editor.apply();
                    Toast.makeText(register.this, "User registered!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(register.this, "Enter value in the fields!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emptyField();
            }
        });
    }
    public void emptyField(){
        nim.setText("");
        username.setText("");
        password.setText("");
    }
}