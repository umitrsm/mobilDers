package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import android.hardware.SensorManager.DynamicSensorCallback;
import static  android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.SensorManager.SENSOR_DELAY_FASTEST;

public class Modlar extends AppCompatActivity {

    private SensorManager sensorManager,sensorManager1;
    private Sensor lightSensor,konumSensor;
    private SensorEventListener lightListener;
    private View root;
    private float maxValue;
    private TextView rootNot;
    private float x,y,z;
    Context contex = this;
    private Toolbar actionBarEmail;
    @SuppressLint("ServiceCast")
    public void init(){
        actionBarEmail = (Toolbar) findViewById(R.id.action_bar_Email);
        setSupportActionBar(actionBarEmail);
        getSupportActionBar().setTitle("Sensör Kullan");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modlar);
        root = findViewById(R.id.root);
        rootNot = findViewById(R.id.rootNot);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        lightSensor = sensorManager.getDefaultSensor(TYPE_LIGHT);
        sensorManager1 = (SensorManager) getSystemService(SENSOR_SERVICE);
        konumSensor = sensorManager1.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        init();

        if (lightSensor == null) {
            Toast.makeText(Modlar.this, "Cihazda Işık Sensörü Bulunamadı", Toast.LENGTH_LONG).show();
        }
        maxValue = lightSensor.getMaximumRange();

        lightListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                float value = event.values[0];
                getSupportActionBar().setTitle("Parlaklık: " + value);
                if (value < 20000.0) {
                    // int newValue = (int) (255f * value / maxValue);
                    root.setBackgroundColor(Color.WHITE);
                    rootNot.setTextColor(Color.BLACK);
                    Toast.makeText(Modlar.this,"Aydınlık Moda Geçildi",Toast.LENGTH_LONG).show();
                    // root.setBackgroundColor(Color.rgb(newValue, newValue, newValue));
                } else {
                    rootNot.setTextColor(Color.WHITE);
                    root.setBackgroundColor(Color.BLACK);
                    Toast.makeText(Modlar.this,"Karanlık Moda Geçildi",Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
    }
        protected void onResume () {
            super.onResume();
            sensorManager.registerListener(lightListener,lightSensor,SensorManager.SENSOR_DELAY_FASTEST);


        }
    }

