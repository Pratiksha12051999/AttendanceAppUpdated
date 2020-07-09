package com.example.attendanceapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class Assignment_status_upload extends AppCompatActivity {

    Button upload, selectFile, fecthFile;
    TextView notification;
    Uri excelUri;
    ProgressDialog progressDialog;

    FirebaseStorage storage;
    FirebaseDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assignment_status_upload);

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

        fecthFile = findViewById(R.id.fetchFile);
        upload = findViewById(R.id.upload);
        selectFile = findViewById(R.id.selectFile);
        notification = findViewById(R.id.notification);
        selectFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Assignment_status_upload.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectExcel();
                }
                else{
                    ActivityCompat.requestPermissions(Assignment_status_upload.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 9);
                }
            }
        });

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (excelUri != null) {
                    uploadFile(excelUri);
                }
                else {
                    Toast.makeText(Assignment_status_upload.this, "Select a file", Toast.LENGTH_SHORT).show();
                }
            }
        });

        fecthFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Assignment_status_upload.this,Assignment_Teacher_status_fetch_r.class));
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            selectExcel();
        }
        else {
            Toast.makeText(Assignment_status_upload.this, "Please provide permission", Toast.LENGTH_SHORT).show();
        }
    }

    private void selectExcel() {
        //Offer user to select file using filemanager
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 86);
    }

    private void uploadFile(final Uri excelUri) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Uploading file...");
        progressDialog.setProgress(0);
        progressDialog.show();

        final String fileName=System.currentTimeMillis()+".xlsx";
        final String fileName1= System.currentTimeMillis()+"";
        StorageReference storageReference = storage.getReference();

        storageReference.child("Uploads_excel_for_ass_status").child(fileName).putFile(excelUri)
        .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                String url = taskSnapshot.getStorage().getDownloadUrl().toString();

                //store in realtime db
                DatabaseReference reference = database.getReference();
                reference.child(fileName1).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Assignment_status_upload.this, "File Successfully uploaded", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(Assignment_status_upload.this, "File not successfully uploaded", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Assignment_status_upload.this, "File not successfully uploaded", Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                //track progress for upload
                int currentProgress = (int)(100*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setProgress(currentProgress);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 86 && resultCode == RESULT_OK && data != null) {
            excelUri = data.getData();
            notification.setText("A file is selected : "+ data.getData().getLastPathSegment());
        } else {
            Toast.makeText(Assignment_status_upload.this, "Please select a file.", Toast.LENGTH_SHORT).show();
        }
    }
}
