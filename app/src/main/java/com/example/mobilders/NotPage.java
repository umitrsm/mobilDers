package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NotPage extends AppCompatActivity {
    EditText notlarım;
    Button Boku,Bguncelle,Bsil;
    private Toolbar actionBarEmail;
    public void init(){
        actionBarEmail = (Toolbar) findViewById(R.id.action_bar_Email);
        setSupportActionBar(actionBarEmail);
        getSupportActionBar().setTitle("Dosya İşlemleri");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_page);
        init();
        Boku = findViewById(R.id.oku);
        Bguncelle = findViewById(R.id.guncelle);
        Bsil = findViewById(R.id.sil);
        notlarım  = findViewById(R.id.notlar);
        Boku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                oku();
            }
        });
        Bguncelle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yaz();
            }
        });
        Bsil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sil();
            }
        });
    }
    void yaz (){
        try {
            FileOutputStream fos = openFileOutput("notlar", Context.MODE_PRIVATE);//Dosyayı Açma Ve Yazma
            String notlar  = notlarım.getText().toString();
            fos.write(notlar.getBytes());
            fos.close();
            Toast.makeText(NotPage.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    void oku(){
        try {
            FileInputStream fis = openFileInput("notlar");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            notlarım.setText(br.readLine());
            fis.close();
            Toast.makeText(NotPage.this,"Okuma Başarılı" ,Toast.LENGTH_LONG).show();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
    void sil() {
        try {
            FileOutputStream fos = openFileOutput("notlar", Context.MODE_PRIVATE);//Dosyayı Açma Ve Yazma
            String not = "";
            fos.write(not.getBytes());
            fos.close();
            Toast.makeText(NotPage.this,"Dosyadaki Bilgiler Silindi",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    }



