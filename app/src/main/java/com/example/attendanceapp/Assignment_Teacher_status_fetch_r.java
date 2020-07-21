package com.example.attendanceapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.Objects;

public class Assignment_Teacher_status_fetch_r extends AppCompatActivity {

    RecyclerView recyclerview;
    Assignment_Teacher_status_fetch_r_Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_teacher_fetch_status_r);


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageReference =  storage.getReferenceFromUrl("gs://attendance-app-3e6d7.appspot.com/Uploads_excel_for_ass_status");

        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                //called for individual items at the database reference
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    String fileName = ds.getKey();
                    String url = ds.child("name").getValue(String.class);
                    Log.i("filename",fileName);
                  //  Log.i("url",url);
                    ((Assignment_Teacher_status_fetch_r_Adapter)recyclerview.getAdapter()).updateAdapter(fileName, url);
                }
//                String fileName =  dataSnapshot.getKey();//filename
//                String url = dataSnapshot.child("Uploads_excel_for_ass_status").getValue(String.class);//url of filename
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerview = findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(Assignment_Teacher_status_fetch_r.this));
        adapter= new Assignment_Teacher_status_fetch_r_Adapter(recyclerview, Assignment_Teacher_status_fetch_r.this, new ArrayList<String>(), new ArrayList<String>());
        recyclerview.setAdapter(adapter);

    }
}
