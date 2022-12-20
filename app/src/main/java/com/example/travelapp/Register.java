package com.example.travelapp;

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

/**

 This is an adapter class for a RecyclerView used to display a list of WondersInfo objects.
 It specifies the layout for each item in the list and what happens when an item is clicked.
 The context and an ArrayList of WondersInfo objects are passed in as arguments to the constructor.
 The context is used to create an Intent for starting a new activity when an item is clicked.
 The ArrayList of WondersInfo objects is used to populate the list with data.
 The onCreateViewHolder method inflates the layout for each item in the list and returns a
 MyViewHolder object.
 The onBindViewHolder method sets the heading TextView and the title image ShapeableImageView
 for each item in the list based on the data in the corresponding WondersInfo object. It also
 sets an OnClickListener for each item in the list that starts a new activity when an item is clicked.
 The getItemCount method returns the size of the ArrayList of WondersInfo objects.
 The MyViewHolder inner class holds the Views for each item in the list.
 */
public class Register extends AppCompatActivity {
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://travelapp-2abe1-default-rtdb.firebaseio.com/");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText fullname = findViewById(R.id.fullname);
        final EditText email = findViewById(R.id.email);
        final EditText phone = findViewById(R.id.phone);
        final EditText password = findViewById(R.id.password);
        final EditText conPassword = findViewById(R.id.conPassword);

        final Button registerBtn = findViewById(R.id.registerBtn);
        final TextView loginNowBtn = findViewById(R.id.loginNow);

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String fullnameTxt = fullname.getText().toString();
                final String emailTxt = email.getText().toString();
                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();
                final String conPasswordTxt = conPassword.getText().toString();

                if(fullnameTxt.isEmpty() || emailTxt.isEmpty() || phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Register.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }


                else if(!passwordTxt.equals(conPasswordTxt)){
                    Toast.makeText(Register.this, "Passwords are not matching", Toast.LENGTH_SHORT).show();
                }

                else{
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(phoneTxt)){
                                Toast.makeText(Register.this, "My phone is already registered", Toast.LENGTH_SHORT).show();
                            }

                            else {

                                databaseReference.child("users").child(phoneTxt).child("fullname").setValue(fullnameTxt);
                                databaseReference.child("users").child(phoneTxt).child("email").setValue(emailTxt);
                                databaseReference.child("users").child(phoneTxt).child("password").setValue(passwordTxt);

                                Toast.makeText(Register.this, "User registered successfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                }
            }
        });

        loginNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}