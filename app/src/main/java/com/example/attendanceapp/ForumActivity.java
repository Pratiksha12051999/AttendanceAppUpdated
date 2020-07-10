package com.example.attendanceapp;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class ForumActivity extends AppCompatActivity {
    EditText text_send;
    ImageButton btn_send;
    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView list;
    private Object FirebaseRecyclerAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("Discussion");
        reference.keepSynced(true);

        list = (RecyclerView) findViewById(R.id.list);
        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(this));

        btn_send = findViewById(R.id.btn_send);
        text_send = findViewById(R.id.text_send);

        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = text_send.getText().toString();
                if (!msg.equals("")) {
                    String a=" ";
                    sendMessage(msg,a);
                } else {
                    Toast.makeText(ForumActivity.this, "Please type your message", Toast.LENGTH_SHORT).show();
                }
                text_send.setText("");
            }
        });
    }

    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Discuss, DiscussViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Discuss, DiscussViewHolder>
                (Discuss.class, R.layout.list_item_layout, DiscussViewHolder.class, reference) {

            @Override
            protected void populateViewHolder(DiscussViewHolder discussViewHolder, Discuss discuss, int i) {
                discussViewHolder.setQuestion(discuss.getQuestion());
                discussViewHolder.setAnswer(discuss.getAnswer());
            }
        };
        list.setAdapter(firebaseRecyclerAdapter);
    }

    public static class DiscussViewHolder extends RecyclerView.ViewHolder {
        Button reply;
        View mView;

        public DiscussViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            reply = (Button) mView.findViewById(R.id.reply);
        }

        public void setQuestion(String question) {
            TextView getquestion = (TextView) mView.findViewById(R.id.getquestion);
            getquestion.setText(question);
        }

        public void setAnswer(final String answer) {
            reply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView giveanswer = (TextView) mView.findViewById(R.id.giveanswer);
                    String ans = giveanswer.getText().toString();
                }
            });
            TextView getanswer = (TextView) mView.findViewById(R.id.getanswer);
            getanswer.setText(answer);
        }
    }


    private static void sendMessage(String message, String answer) {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("question", message);
        hashMap.put("answer", answer);
        reference.child("Discussion").child(message).setValue(hashMap);
    }

}