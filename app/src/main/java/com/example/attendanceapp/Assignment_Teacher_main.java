package com.example.attendanceapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import static android.widget.Toast.makeText;

public class Assignment_Teacher_main extends AppCompatActivity implements View.OnClickListener{
    Button newassign, status;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_assignment_uploadandstatus);

        newassign = findViewById(R.id.newassign);
        status = findViewById(R.id.status);

        newassign.setOnClickListener(this);
        status.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.newassign:
                    makeText(this,"Upload new assignment",Toast.LENGTH_SHORT).show();
                    Intent assign = new Intent(this, Assignment_yearbutton.class);
                    startActivity(assign);
                    break;

                case R.id.status:
                    makeText(this,"Status of assignment",Toast.LENGTH_SHORT).show();
                    Intent status = new Intent(this, Assignment_Teacher_status1.class);
                    startActivity(status);
                    break;

            }
    }
}
