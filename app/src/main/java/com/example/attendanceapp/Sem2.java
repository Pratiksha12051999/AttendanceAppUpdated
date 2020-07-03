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

public class Sem2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sem2);

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

                                    TextView AM21=(TextView)findViewById(R.id.textAM21);
                                    TextView AM22=(TextView)findViewById(R.id.textAM22);
                                    TextView AM23=(TextView)findViewById(R.id.textAM23);
                                    TextView AM24=(TextView)findViewById(R.id.textAM24);

                                    AM21.setText(values.get("AMII IA").toString()+"/20");
                                    AM22.setText(values.get("AMII IA").toString()+"/20");
                                    AM23.setText(values.get("AMII IA").toString()+"/20");
                                    AM24.setText(values.get("AMII SE").toString()+"/80");

                                    TextView AP21=(TextView)findViewById(R.id.textAP21);
                                    TextView AP22=(TextView)findViewById(R.id.textAP22);
                                    TextView AP23=(TextView)findViewById(R.id.textAP23);
                                    TextView AP24=(TextView)findViewById(R.id.textAP24);

                                    AP21.setText(values.get("APII IA").toString()+"/15");
                                    AP22.setText(values.get("APII IA").toString()+"/15");
                                    AP23.setText(values.get("APII IA").toString()+"/15");
                                    AP24.setText(values.get("APII SE").toString()+"/60");

                                    TextView AC21=(TextView)findViewById(R.id.textAC21);
                                    TextView AC22=(TextView)findViewById(R.id.textAC22);
                                    TextView AC23=(TextView)findViewById(R.id.textAC23);
                                    TextView AC24=(TextView)findViewById(R.id.textAC24);

                                    AC21.setText(values.get("ACII IA").toString()+"/15");
                                    AC22.setText(values.get("ACII IA").toString()+"/15");
                                    AC23.setText(values.get("ACII IA").toString()+"/15");
                                    AC24.setText(values.get("ACII SE").toString()+"/60");

                                    TextView ED1=(TextView)findViewById(R.id.textED1);
                                    TextView ED2=(TextView)findViewById(R.id.textED2);
                                    TextView ED3=(TextView)findViewById(R.id.textED3);
                                    TextView ED4=(TextView)findViewById(R.id.textED4);

                                    ED1.setText(values.get("ED IA").toString()+"/15");
                                    ED2.setText(values.get("ED IA").toString()+"/15");
                                    ED3.setText(values.get("ED IA").toString()+"/15");
                                    ED4.setText(values.get("ED SE").toString()+"/60");

                                    TextView SPA1=(TextView)findViewById(R.id.textSPA1);
                                    TextView SPA2=(TextView)findViewById(R.id.textSPA2);
                                    TextView SPA3=(TextView)findViewById(R.id.textSPA3);
                                    TextView SPA4=(TextView)findViewById(R.id.textSPA4);

                                    SPA1.setText(values.get("SPA IA").toString()+"/20");
                                    SPA2.setText(values.get("SPA IA").toString()+"/20");
                                    SPA3.setText(values.get("SPA IA").toString()+"/20");
                                    SPA4.setText(values.get("SPA SE").toString()+"/80");

                                    TextView CS1=(TextView)findViewById(R.id.textCS1);
                                    TextView CS2=(TextView)findViewById(R.id.textCS2);
                                    TextView CS3=(TextView)findViewById(R.id.textCS3);
                                    TextView CS4=(TextView)findViewById(R.id.textCS4);

                                    CS1.setText(values.get("CS IA").toString()+"/10");
                                    CS2.setText(values.get("CS IA").toString()+"/10");
                                    CS3.setText(values.get("CS IA").toString()+"/10");
                                    CS4.setText(values.get("CS SE").toString()+"/40");

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