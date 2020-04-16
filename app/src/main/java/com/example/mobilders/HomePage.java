package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends AppCompatActivity {

    private Button bemail,bkullanici,bsensor,bnot;

    public void init(){
        bemail = (Button) findViewById(R.id.emailekrani);
        bkullanici = (Button) findViewById(R.id.kullaniciekrani);
        bsensor = (Button) findViewById(R.id.sensorler);
        bnot= (Button) findViewById(R.id.Bnot);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        init();
        SharedPreferences preferences = getSharedPreferences("MY_PREFS",MODE_PRIVATE);
        String display = preferences.getString("display","");

        bemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentEmail = new Intent(HomePage.this, Email.class);
                startActivity(intentEmail);
            }
        });

        bkullanici.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentKullanici = new Intent(HomePage.this, User.class);
                startActivity(intentKullanici);
            }
        });

        bsensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentSensor = new Intent(HomePage.this, SensorList.class);
                startActivity(intentSensor);
            }
        });
        bnot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentNot = new Intent(HomePage.this, NotPage.class);
                startActivity(intentNot);
            }
        });
    }
}
