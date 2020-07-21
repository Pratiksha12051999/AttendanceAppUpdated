package com.example.attendanceapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Assignment_Teacher_status_fetch_r_Adapter extends RecyclerView.Adapter<Assignment_Teacher_status_fetch_r_Adapter.ViewHolder> {

    RecyclerView recyclerview;
    Context context;
    ArrayList<String> items = new ArrayList<>();
    ArrayList<String> urls = new ArrayList<>();


    public void updateAdapter(String name, String url){
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();//refereshes the recycler view automatically
    }


    public Assignment_Teacher_status_fetch_r_Adapter(RecyclerView recyclerview, Context context, ArrayList<String> items, ArrayList<String> urls) {
        this.recyclerview = recyclerview;
        this.context = context;
        this.items = items;
        this.urls = urls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_assignment_teacher_fetch_status_c, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameOfFile.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameOfFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfFile = itemView.findViewById(R.id.nameOfFile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = recyclerview.getChildLayoutPosition(view);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(urls.get(position)));
                    context.startActivity(intent);
                }
            });
        }
    }
}
