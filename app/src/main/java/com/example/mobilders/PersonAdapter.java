package com.example.mobilders;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.MyViewHolder> {

    ArrayList<Person> mPersonList;
    LayoutInflater inflater;

    public PersonAdapter(Context context,ArrayList<Person> people){
        inflater = LayoutInflater.from(context);
        this.mPersonList=people;
    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = inflater.inflate(R.layout.item_user,parent,false);
        MyViewHolder holder = new MyViewHolder (view);
        return holder;
    }



    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person selectedPerson = mPersonList.get(position);
        holder.setData(selectedPerson,position);

    }

    @Override
    public int getItemCount() {
        return mPersonList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener {
        TextView username;
        ImageView personImage;
        public MyViewHolder(View itemViev){
            super(itemViev);
            username = (TextView) itemViev.findViewById(R.id.personName);
            personImage = (ImageView) itemViev.findViewById(R.id.PersonImage);
        }
        public void setData(Person selectedPerson,int position) {
            this.username.setText(selectedPerson.getUsername());
            this.personImage.setImageResource(selectedPerson.getImageId());
        }

        @Override
        public void onClick(View v) {

        }
    }

}
