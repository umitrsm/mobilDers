package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity  {

    Button bLogin;
    String pass,name;
    private Toolbar actionBarLogin;
    public void init(){
        actionBarLogin = (Toolbar) findViewById(R.id.action_bar_Login);
        setSupportActionBar(actionBarLogin);
        getSupportActionBar().setTitle("Giriş Yap");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        final EditText etUsername=(EditText) findViewById(R.id.txtusername1);
        final EditText etPassword=(EditText) findViewById(R.id.txtpassword1);
        bLogin=(Button) findViewById(R.id.bLogin);



        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name=etUsername.getText().toString();
                pass=etPassword.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MY_PREFS",MODE_PRIVATE);
                String newUserDetails = name + pass;

                String userDetails = preferences.getString(name +pass ,"Bilgiler Hatalı");
                if(newUserDetails.equals(userDetails)) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("display", userDetails);
                    editor.commit();
                    Toast.makeText(LoginActivity.this,"Hoşgeldiniz:"+name,Toast.LENGTH_LONG).show();

                    Intent loggedIn = new Intent(LoginActivity.this, HomePage.class);
                    startActivity(loggedIn);
                }
                else{
                    Toast.makeText(LoginActivity.this,"Kullanıcı Adı veya Şifre Yanlış",Toast.LENGTH_LONG).show();
                }

            }
        });
        }

    }

