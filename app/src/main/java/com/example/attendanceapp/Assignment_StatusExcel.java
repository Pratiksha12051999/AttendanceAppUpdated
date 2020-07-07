package com.example.attendanceapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.FileAsyncHttpResponseHandler;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class Assignment_StatusExcel extends AppCompatActivity {
    public static final String TAG = "TAG";
    RecyclerView recyclerView;
    Assignment_StatusExcelAdapter adapter;
    AsyncHttpClient client;
    Workbook workbook;
    List<String> studentName, status;
    Uri excelUri;

    FirebaseStorage storage;
    FirebaseDatabase database;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_r);

        recyclerView = findViewById(R.id.list);

        studentName = new ArrayList<>();
        status = new ArrayList<>();

       String url="C:/Users/Sonia/Desktop/Sub1.xlsx";
        client = new AsyncHttpClient();
        client.get(url, new FileAsyncHttpResponseHandler(this) {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                Toast.makeText(Assignment_StatusExcel.this,"Download Failed. ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, File file) {
                Toast.makeText(Assignment_StatusExcel.this,"Download Successfully. ", Toast.LENGTH_SHORT).show();
                WorkbookSettings ws = new WorkbookSettings();
                ws.setGCDisabled(true);
                if(file != null){
                    try {
                        workbook = workbook.getWorkbook(file);
                        Sheet sheet = workbook.getSheet(0);
                        for(int i=0 ; i<sheet.getRows(); i++){

                            Cell[] row =sheet.getRow(i);
                            studentName.add(row[0].getContents());
                            status.add(row[1].getContents());
                        }
                        showData();
                        //String url = task.getResult().toString().substring(0,task.getResult().toString().indexOf("&token"));

//                        Log.d("TAG", "onSuccess:" +studentName);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (BiffException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


    }

    private void showData() {
        adapter = new Assignment_StatusExcelAdapter(this, studentName, status);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}

