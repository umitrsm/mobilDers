package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Email extends AppCompatActivity {
    private EditText adres;
    private EditText baslik;
    private EditText icerik;
    private Button bsend;
    private Toolbar actionBarEmail;
    public void init(){
        actionBarEmail = (Toolbar) findViewById(R.id.action_bar_Email);
        setSupportActionBar(actionBarEmail);
        getSupportActionBar().setTitle("Email Gönder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        init();
        adres = findViewById(R.id.emailadresi);
        baslik = findViewById(R.id.baslik);
        icerik = findViewById(R.id.icerik);
        bsend = findViewById(R.id.bsend);
        bsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });

    }
    private void sendMail(){
        String alici = adres.getText().toString();
        String[] alicilar = alici.split("/n");
        String subject = baslik.getText().toString();
        String message = icerik.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,alicilar);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);

        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Alıcı Adresi Seçiniz"));

    }
}
