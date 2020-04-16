package com.example.mobilders;


import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Person extends AppCompatActivity implements Serializable {
    private String username;

    public int getImageId() {
        return ImageId;
    }

    public void setImageId(int imageId) {
        ImageId = imageId;
    }

    private int ImageId;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String email;
    private String password;
    Person(){};

    Person(String username,String email,String password){
        this.email=email;
        this.password=password;
        this.username=username;
    }
    Person(String username,String password){
        this.username=username;
        this.password=password;
    }
    public  static ArrayList<Person> getData () {
        ArrayList<Person> personList = new ArrayList<Person>();
        int ImageIda[] = {R.drawable.foto1, R.drawable.foto2, R.drawable.foto3, R.drawable.foto4, R.drawable.foto5,
                R.drawable.foto6, R.drawable.foto7,R.drawable.foto8, R.drawable.foto9, R.drawable.foto10};
       String[] userNames = {"Kemal Sayan", "Selin Öznur", "Yeliz Sarı", "Mustafa Kuru", "Ragıp Turan", "Yeşim Türlü",
                "Elif Arkut", "Kamil Alıc", "Sami Şahin", "Ayşe Caner"};
        int i;
        for (i = 0; i < 10;i++){
            Person temp = new Person();
            temp.setImageId(ImageIda[i]);
            temp.setUsername(userNames[i]);
            personList.add(temp);
        }

        return personList;
    }
}
