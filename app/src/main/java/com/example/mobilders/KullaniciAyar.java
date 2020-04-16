package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class KullaniciAyar extends AppCompatActivity {
    private Toolbar actionBarEmail;
     private EditText adi,boyu,kilo,bilgi;
    private RadioButton erkek,kadin;
    private Button ekle,bul;
    private DatePicker dogum;
    private  String mod= "" ;
    private String bilgiler = "" ;
    private ToggleButton toggle ;

    public void init(){
        actionBarEmail = (Toolbar) findViewById(R.id.action_bar_Email);
        setSupportActionBar(actionBarEmail);
        getSupportActionBar().setTitle("Email Gönder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        adi = (EditText) findViewById(R.id.adicevap);
        boyu = ( EditText) findViewById(R.id.boycevap);
        kilo = (EditText) findViewById(R.id.kilocevap);
        erkek = (RadioButton) findViewById(R.id.erkek);
        kadin = (RadioButton) findViewById(R.id.kadin);
        ekle = (Button) findViewById(R.id.guncelle);
        bul = (Button) findViewById(R.id.oku);
        dogum = (DatePicker) findViewById(R.id.datePicker1);
        bilgi = ( EditText) findViewById(R.id.notlar);
        toggle = (ToggleButton) findViewById(R.id.toggle1);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_ayar);
        init();
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mod ="Light";
                } else {
                    mod = "Dark";
                }
            }
        });
        bul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                okuma();
            }
        });
        ekle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yazma();
            }
        });
    }

    void yazma () {
        SharedPreferences preferences = getSharedPreferences("MY_PREFS1",MODE_PRIVATE);
        String Kadi = adi.getText().toString();
        String Kboyu = boyu.getText().toString();
        String Kkilo = kilo.getText().toString();
        String Kcinsiyet="";
        int Kyas = 2020 - dogum.getYear();
        if(erkek.isChecked()&&kadin.isChecked()){
            Toast.makeText(KullaniciAyar.this,"Erkek veya Kadın Seçiniz",Toast.LENGTH_LONG).show();
        }
        else if  (erkek.isChecked()){
            Kcinsiyet = "Erkek";
        }
        else{
            Kcinsiyet="Kadin";
        }

        SharedPreferences.Editor editor = preferences.edit();
        bilgiler = ("İsim: " + Kadi +"\nCinsiyet: " + Kcinsiyet + "\nKilo: " + Kkilo +"  Boy: " +Kboyu + "\nYaş: " + Kyas + "\nMod: " + mod  );
        editor.putString(Kadi,bilgiler);
        editor.commit();
        Toast.makeText(KullaniciAyar.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();
    }
    void  okuma (){
        SharedPreferences preferences = getSharedPreferences("MY_PREFS1",MODE_PRIVATE);
        String isimKey = adi.getText().toString();
        String Okunan = preferences.getString(isimKey,"Hatalı Kullanıcı Adı");
        bilgi.setText(Okunan);

    }
}

