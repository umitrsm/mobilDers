package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

        private Button welcomeLoginOne,welcomeLoginTwo;

        public void init(){
            welcomeLoginOne = (Button) findViewById(R.id.hesapOlustur);
            welcomeLoginTwo = (Button) findViewById(R.id.hesapVar);

        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        welcomeLoginOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentRegister = new Intent(MainActivity.this ,RegisterActivity.class);
                startActivity(intentRegister);
            }
        });
        welcomeLoginTwo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String packageContext;
                Intent intentLogin = new Intent(MainActivity.this ,LoginActivity.class);
                startActivity(intentLogin);
            }
        });
    }
}
