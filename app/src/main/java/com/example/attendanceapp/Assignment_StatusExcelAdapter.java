package com.example.attendanceapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Assignment_StatusExcelAdapter extends RecyclerView.Adapter<Assignment_StatusExcelAdapter.ViewHolder> {
    LayoutInflater inflator;
    List<String> studentName, status;

    public Assignment_StatusExcelAdapter(Context context, List<String> studentName, List<String> status) {
        this.inflator = LayoutInflater.from(context);
        this.studentName = studentName;
        this.status = status;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflator.inflate(R.layout.activity_custom_layout_status,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    String studentname = studentName.get(position);
    String status_s =  status.get(position);

    holder.studentname.setText(studentname);
    holder.status.setText(status_s);
    }

    @Override
    public int getItemCount() {
        return studentName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView studentname,status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            studentname = itemView.findViewById(R.id.studentName);
            status = itemView.findViewById(R.id.status);
        }
    }


}
