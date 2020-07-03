package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class Sem4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem4);

        FirebaseUser current= FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference dbResults= FirebaseDatabase.getInstance().getReference();
        dbResults.child("Users").child(current.getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    UserDetails details=dataSnapshot.getValue(UserDetails.class);
                    String admno=details.admissionno.toString();
                    Query query=FirebaseDatabase.getInstance().getReference("1xdYDgDXnj1ZVODHEdcSAv51ex58GuGVPBrBTQVFOrUs/Sheet1").orderByChild("admissionno").equalTo(admno);
                    query.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                for (DataSnapshot issue : dataSnapshot.getChildren()) {
                                    Map<String, Object> values=(Map<String, Object>)issue.getValue();

                                    TextView studentname=(TextView)findViewById(R.id.textStudentName);
                                    studentname.setText(values.get("Name").toString());

                                    TextView AM41=(TextView)findViewById(R.id.textAM41);
                                    TextView AM42=(TextView)findViewById(R.id.textAM42);
                                    TextView AM43=(TextView)findViewById(R.id.textAM43);
                                    TextView AM44=(TextView)findViewById(R.id.textAM44);

                                    AM41.setText(values.get("AMIV IA").toString()+"/20");
                                    AM42.setText(values.get("AMIV IA").toString()+"/20");
                                    AM43.setText(values.get("AMIV IA").toString()+"/20");
                                    AM44.setText(values.get("AMIV SE").toString()+"/80");

                                    TextView AOA1=(TextView)findViewById(R.id.textAOA1);
                                    TextView AOA2=(TextView)findViewById(R.id.textAOA2);
                                    TextView AOA3=(TextView)findViewById(R.id.textAOA3);
                                    TextView AOA4=(TextView)findViewById(R.id.textAOA4);

                                    AOA1.setText(values.get("AOA IA").toString()+"/20");
                                    AOA2.setText(values.get("AOA IA").toString()+"/20");
                                    AOA3.setText(values.get("AOA IA").toString()+"/20");
                                    AOA4.setText(values.get("AOA SE").toString()+"/80");

                                    TextView COA1=(TextView)findViewById(R.id.textCOA1);
                                    TextView COA2=(TextView)findViewById(R.id.textCOA2);
                                    TextView COA3=(TextView)findViewById(R.id.textCOA3);
                                    TextView COA4=(TextView)findViewById(R.id.textCOA4);

                                    COA1.setText(values.get("COA IA").toString()+"/20");
                                    COA2.setText(values.get("COA IA").toString()+"/20");
                                    COA3.setText(values.get("COA IA").toString()+"/20");
                                    COA4.setText(values.get("COA SE").toString()+"/80");

                                    TextView CG1=(TextView)findViewById(R.id.textCG1);
                                    TextView CG2=(TextView)findViewById(R.id.textCG2);
                                    TextView CG3=(TextView)findViewById(R.id.textCG3);
                                    TextView CG4=(TextView)findViewById(R.id.textCG4);

                                    CG1.setText(values.get("CG IA").toString()+"/20");
                                    CG2.setText(values.get("CG IA").toString()+"/20");
                                    CG3.setText(values.get("CG IA").toString()+"/20");
                                    CG4.setText(values.get("CG SE").toString()+"/80");

                                    TextView OS1=(TextView)findViewById(R.id.textOS1);
                                    TextView OS2=(TextView)findViewById(R.id.textOS2);
                                    TextView OS3=(TextView)findViewById(R.id.textOS3);
                                    TextView OS4=(TextView)findViewById(R.id.textOS4);

                                    OS1.setText(values.get("OS IA").toString()+"/20");
                                    OS2.setText(values.get("OS IA").toString()+"/20");
                                    OS3.setText(values.get("OS IA").toString()+"/20");
                                    OS4.setText(values.get("OS SE").toString()+"/80");

                                }
                            }
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
