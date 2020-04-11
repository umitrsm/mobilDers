package com.example.mobilders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class RegisterActivity extends AppCompatActivity {
    Button bRegister;


    private Toolbar actionBarRegister;
    public void init(){
        actionBarRegister = (Toolbar) findViewById(R.id.action_bar_Register);
        setSupportActionBar(actionBarRegister);
        getSupportActionBar().setTitle("Kayıt Ol");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();

        final EditText etUsername=(EditText) findViewById(R.id.txtusername);
        final EditText etEmail=(EditText) findViewById(R.id.txtemail);
        final EditText etPassword=(EditText) findViewById(R.id.txtpassword);
        bRegister=(Button) findViewById(R.id.bregister);




        bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MY_PREFS",MODE_PRIVATE);
                String newUsername = etUsername.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                String a="";
                SharedPreferences.Editor editor = preferences.edit();
                a=(newUsername + password + newUsername +"\n" + email);
                Toast.makeText(RegisterActivity.this,a,Toast.LENGTH_LONG).show();
                editor.putString(newUsername + password ,newUsername +password);
                editor.commit();
                Toast.makeText(RegisterActivity.this,"Kayıt Başarılı",Toast.LENGTH_LONG).show();
                String packageContext;
                Intent intentFinishRegister = new Intent(RegisterActivity.this ,MainActivity.class);
                startActivity(intentFinishRegister);
                Map<String, ?> allEntries = preferences.getAll();
                for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                    Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
                }
            }
         });
    }


}

