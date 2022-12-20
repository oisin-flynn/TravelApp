package com.example.travelapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    // Initialize Firebase Realtime Database reference
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://travelapp-2abe1-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);

        // Set up click listener for login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get phone and password entered by user
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();

                // Check if phone or password field is empty
                if(phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    // Display toast message if either field is empty
                    Toast.makeText(Login.this, "Please enter your mobile or password", Toast.LENGTH_SHORT).show();
                }
                else {
                    // Read from the "users" node in the database
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            // Check if the phone number entered by the user exists in the databas
                            if (snapshot.hasChild(phoneTxt)){
                                // Get the password for the phone number from the database
                                final String getPassword = snapshot.child(phoneTxt).child("password").getValue(String.class);
                                // Compare the password entered by the user to the password in the database
                                if (getPassword.equals(passwordTxt)){
                                    // Display toast message and redirect to main activity if password is correct
                                    Toast.makeText(Login.this, "Successfully logged in", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this, MainActivity3.class));
                                    finish();
                                }
                                else {
                                    // Display toast message if password is incorrect
                                    Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Login.this, "Incorrect password", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        // Set up click listener for register button
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navigate to register activity
                startActivity(new Intent(Login.this, Register.class));
            }
        });
    }
}