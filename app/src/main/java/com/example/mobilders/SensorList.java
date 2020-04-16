package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class SensorList extends AppCompatActivity {
    private SensorManager sensorManager;
    TextView liste;
    private Toolbar actionBarEmail;
    public void init(){
    actionBarEmail = (Toolbar) findViewById(R.id.action_bar_Email);
    setSupportActionBar(actionBarEmail);
    getSupportActionBar().setTitle("Sensör Lİstesi");
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list);
        init();
        sensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> deviceSensors=sensorManager.getSensorList(Sensor.TYPE_ALL);
        liste = findViewById(R.id.sensorliste);
        String a ="";
        a+=deviceSensors.size()+" Adet Sensör Tespit Edildi!\n";

            for(int i=0;i<deviceSensors.size();i++){
                a+=i+1+" " + deviceSensors.get(i).getName() + "\n";
            }
        liste.setText(a);
    }
}
