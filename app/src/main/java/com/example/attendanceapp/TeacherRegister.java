package com.example.attendanceapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class TeacherRegister extends AppCompatActivity {
    EditText emailTeacherRegister;
    EditText passwordTeacherRegister;
    TextView alreadyRegisteredTeacher;
    Button registerTeacherButton;
    FirebaseAuth firebaseAuth;
    CheckBox showPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_register);
        emailTeacherRegister = findViewById(R.id.titleTextBox);
        passwordTeacherRegister = findViewById(R.id.passwordTeacherRegister);
        alreadyRegisteredTeacher = findViewById(R.id.alreadyRegisteredTeacher);
        registerTeacherButton = findViewById(R.id.submitButton);
        showPassword = findViewById(R.id.showPassword4);

        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    passwordTeacherRegister.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    passwordTeacherRegister.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });

        alreadyRegisteredTeacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent TeacherLoginIntent = new Intent(TeacherRegister.this, TeacherActivity.class);
                startActivity(TeacherLoginIntent);
            }
        });

        registerTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email = emailTeacherRegister.getText().toString().trim();
                final String pwd = passwordTeacherRegister.getText().toString().trim();
                String emailIsValid = "@ves.ac.in";
                Boolean emailValidBooleanteacher = false;
                if(email.contains(emailIsValid))
                {
                    emailValidBooleanteacher = true;
                }
                if(email.isEmpty()){
                    emailTeacherRegister.setError("Please enter an Email");
                    emailTeacherRegister.requestFocus();
                }
                else if(pwd.isEmpty())
                {
                    passwordTeacherRegister.setError("Please enter a password");
                    passwordTeacherRegister.requestFocus();
                }
                else if(pwd.length() <=6 ){
                    passwordTeacherRegister.setError("Password should be greater than 6 characters");
                    passwordTeacherRegister.requestFocus();
                }
                else if(!(email.isEmpty()) && !(pwd.isEmpty()) && emailValidBooleanteacher){
                    Query query1 = FirebaseDatabase.getInstance().getReference("TeacherData")
                            .orderByChild("email")
                            .equalTo(email);
                    query1.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                            if(dataSnapshot1.exists()){
                                firebaseAuth = FirebaseAuth.getInstance();
                                firebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if(task.isSuccessful()){
                                            Teacher teacher = new Teacher(
                                                    email,
                                                    pwd
                                            );
                                            FirebaseDatabase.getInstance().getReference("Teachers")
                                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                                    .setValue(teacher).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful()){
                                                        Toast.makeText(TeacherRegister.this, "Teacher Registered Successfully", Toast.LENGTH_SHORT).show();
                                                        Intent goToLogin = new Intent(TeacherRegister.this, TeacherActivity.class);
                                                        startActivity(goToLogin);
                                                    }
                                                    else{
                                                        Toast.makeText(TeacherRegister.this, "Teacher Registeration unsuccessful", Toast.LENGTH_SHORT).show();
                                                    }
                                                }
                                            });
                                        }
                                        else {
                                            Toast.makeText(TeacherRegister.this, "Error during Registration", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Teacher not found!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            throw databaseError.toException();
                        }
                    });
                }
                else{
                    emailTeacherRegister.setError("Please enter VES Email ID");
                    emailTeacherRegister.requestFocus();
                }
            }
        });
    }
}
