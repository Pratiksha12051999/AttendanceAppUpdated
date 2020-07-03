package com.example.attendanceapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Assignment_subject_sem1 extends AppCompatActivity implements View.OnClickListener{
    Button sub1, sub2, sub3 ,sub4, sub5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem1_assignment);

        sub1= findViewById(R.id.sub1);
        sub2= findViewById(R.id.sub2);
        sub3 = findViewById(R.id.sub3);
        sub4= findViewById(R.id.sub4);
        sub5= findViewById(R.id.sub5);

        sub1.setOnClickListener(this);
        sub2.setOnClickListener(this);
        sub3.setOnClickListener(this);
        sub4.setOnClickListener(this);
        sub5.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.sub1:
                Toast.makeText(this,"Subject 1",Toast.LENGTH_SHORT).show();
                Intent sub1 = new Intent(this, ShowAssignment_sem1_sub1.class);
                startActivity(sub1);
                break;
            case R.id.sub2:
                Toast.makeText(this,"Subject 2",Toast.LENGTH_SHORT).show();
                Intent sub2 = new Intent(this, ShowAssignment_sem1_sub2.class);
                startActivity(sub2);
                break;
            case R.id.sub3:
                Toast.makeText(this,"Subject 3",Toast.LENGTH_SHORT).show();
                Intent sub3 = new Intent(this, ShowAssignment_sem1_sub3.class);
                startActivity(sub3);
                break;
            case R.id.sub4:
                Toast.makeText(this,"Subject 4",Toast.LENGTH_SHORT).show();
                Intent sub4 = new Intent(this, ShowAssignment_sem1_sub4.class);
                startActivity(sub4);
                break;
            case R.id.sub5:
                Toast.makeText(this,"Subject 5",Toast.LENGTH_SHORT).show();
                Intent sub5 = new Intent(this, ShowAssignment_sem1_sub5.class);
                startActivity(sub5);
                break;
        }
    }
}
