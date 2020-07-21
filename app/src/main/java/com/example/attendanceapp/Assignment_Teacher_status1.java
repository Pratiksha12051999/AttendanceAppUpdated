package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.makeText;

public class Assignment_Teacher_status1 extends AppCompatActivity implements View.OnClickListener {

    Button sem1sub1, sem1sub2, sem1sub3, sem1sub4, sem1sub5;
    Button sem2sub1, sem2sub2, sem2sub3, sem2sub4, sem2sub5;
    Button sem3sub1, sem3sub2, sem3sub3, sem3sub4, sem3sub5;
    Button sem4sub1, sem4sub2, sem4sub3, sem4sub4, sem4sub5;
    Button sem5sub1, sem5sub2, sem5sub3, sem5sub4, sem5sub5;
    Button sem6sub1, sem6sub2, sem6sub3, sem6sub4, sem6sub5;
    Button sem7sub1, sem7sub2, sem7sub3, sem7sub4, sem7sub5;
    Button sem8sub1, sem8sub2, sem8sub3, sem8sub4, sem8sub5;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_subject1);

        sem1sub1 = findViewById(R.id.sem1sub1);
        sem1sub2 = findViewById(R.id.sem1sub2);
        sem1sub3 = findViewById(R.id.sem1sub3);
        sem1sub4 = findViewById(R.id.sem1sub4);
        sem1sub5 = findViewById(R.id.sem1sub5);

        sem2sub1 = findViewById(R.id.sem2sub1);
        sem2sub2 = findViewById(R.id.sem2sub2);
        sem2sub3 = findViewById(R.id.sem2sub3);
        sem2sub4 = findViewById(R.id.sem2sub4);
        sem2sub5 = findViewById(R.id.sem2sub5);

        sem3sub1 = findViewById(R.id.sem3sub1);
        sem3sub2 = findViewById(R.id.sem3sub2);
        sem3sub3 = findViewById(R.id.sem3sub3);
        sem3sub4 = findViewById(R.id.sem3sub4);
        sem3sub5 = findViewById(R.id.sem3sub5);

        sem4sub1 = findViewById(R.id.sem4sub1);
        sem4sub2 = findViewById(R.id.sem4sub2);
        sem4sub3 = findViewById(R.id.sem4sub3);
        sem4sub4 = findViewById(R.id.sem4sub4);
        sem4sub5 = findViewById(R.id.sem4sub5);

        sem5sub1 = findViewById(R.id.sem5sub1);
        sem5sub2 = findViewById(R.id.sem5sub2);
        sem5sub3 = findViewById(R.id.sem5sub3);
        sem5sub4 = findViewById(R.id.sem5sub4);
        sem5sub5 = findViewById(R.id.sem5sub5);

        sem6sub1 = findViewById(R.id.sem6sub1);
        sem6sub2 = findViewById(R.id.sem6sub2);
        sem6sub3 = findViewById(R.id.sem6sub3);
        sem6sub4 = findViewById(R.id.sem6sub4);
        sem6sub5 = findViewById(R.id.sem6sub5);

        sem7sub1 = findViewById(R.id.sem7sub1);
        sem7sub2 = findViewById(R.id.sem7sub2);
        sem7sub3 = findViewById(R.id.sem7sub3);
        sem7sub4 = findViewById(R.id.sem7sub4);
        sem7sub5 = findViewById(R.id.sem7sub5);

        sem8sub1 = findViewById(R.id.sem8sub1);
        sem8sub2 = findViewById(R.id.sem8sub2);
        sem8sub3 = findViewById(R.id.sem8sub3);
        sem8sub4 = findViewById(R.id.sem8sub4);
        sem8sub5 = findViewById(R.id.sem8sub5);

//        nextto2 = findViewById(R.id.nextto2);
//        nextto2.setOnClickListener(this);
            sem1sub1.setOnClickListener(this);
            sem1sub2.setOnClickListener(this);
            sem1sub3.setOnClickListener(this);
            sem1sub4.setOnClickListener(this);
            sem1sub5.setOnClickListener(this);

            sem2sub1.setOnClickListener(this);
            sem2sub2.setOnClickListener(this);
            sem2sub3.setOnClickListener(this);
            sem2sub4.setOnClickListener(this);
            sem2sub5.setOnClickListener(this);

            sem3sub1.setOnClickListener(this);
            sem3sub2.setOnClickListener(this);
            sem3sub3.setOnClickListener(this);
            sem3sub4.setOnClickListener(this);
            sem3sub5.setOnClickListener(this);

            sem4sub1.setOnClickListener(this);
            sem4sub2.setOnClickListener(this);
            sem4sub3.setOnClickListener(this);
            sem4sub4.setOnClickListener(this);
            sem4sub5.setOnClickListener(this);

            sem5sub1.setOnClickListener(this);
            sem5sub2.setOnClickListener(this);
            sem5sub3.setOnClickListener(this);
            sem5sub4.setOnClickListener(this);
            sem5sub5.setOnClickListener(this);

            sem6sub1.setOnClickListener(this);
            sem6sub2.setOnClickListener(this);
            sem6sub3.setOnClickListener(this);
            sem6sub4.setOnClickListener(this);
            sem6sub5.setOnClickListener(this);

            sem7sub1.setOnClickListener(this);
            sem7sub2.setOnClickListener(this);
            sem7sub3.setOnClickListener(this);
            sem7sub4.setOnClickListener(this);
            sem7sub5.setOnClickListener(this);

            sem8sub1.setOnClickListener(this);
            sem8sub2.setOnClickListener(this);
            sem8sub3.setOnClickListener(this);
            sem8sub4.setOnClickListener(this);
            sem8sub5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.sem1sub1):
                makeText(this,"SEM1-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem1sub2):
                makeText(this,"SEM1-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem1sub3):
                makeText(this,"SEM1-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem1sub4):
                makeText(this,"SEM1-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem1sub5):
                makeText(this,"SEM1-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem2sub1):
                makeText(this,"SEM2-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem2sub2):
                makeText(this,"SEM2-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem2sub3):
                makeText(this,"SEM2-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem2sub4):
                makeText(this,"SEM2-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem2sub5):
                makeText(this,"SEM2-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem3sub1):
                makeText(this,"SEM3-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem3sub2):
                makeText(this,"SEM3-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem3sub3):
                makeText(this,"SEM3-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem3sub4):
                makeText(this,"SEM1-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem3sub5):
                makeText(this,"SEM3-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem4sub1):
                makeText(this,"SEM4-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem4sub2):
                makeText(this,"SEM4-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem4sub3):
                makeText(this,"SEM4-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem4sub4):
                makeText(this,"SEM4-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem4sub5):
                makeText(this,"SEM4-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem5sub1):
                makeText(this,"SEM5-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem5sub2):
                makeText(this,"SEM5-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem5sub3):
                makeText(this,"SEM5-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem5sub4):
                makeText(this,"SEM5-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem5sub5):
                makeText(this,"SEM5-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem6sub1):
                makeText(this,"SEM6-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem6sub2):
                makeText(this,"SEM6-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem6sub3):
                makeText(this,"SEM6-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem6sub4):
                makeText(this,"SEM6-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem6sub5):
                makeText(this,"SEM6-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem7sub1):
                makeText(this,"SEM7-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem7sub2):
                makeText(this,"SEM7-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem7sub3):
                makeText(this,"SEM7-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem7sub4):
                makeText(this,"SEM7-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem7sub5):
                makeText(this,"SEM7-SEM5", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem8sub1):
                makeText(this,"SEM8-SEM1", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem8sub2):
                makeText(this,"SEM8-SEM2", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem8sub3):
                makeText(this,"SEM8-SEM3", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem8sub4):
                makeText(this,"SEM8-SEM4", Toast.LENGTH_SHORT).show();
                break;
            case(R.id.sem8sub5):
                makeText(this,"SEM8-SEM5", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
