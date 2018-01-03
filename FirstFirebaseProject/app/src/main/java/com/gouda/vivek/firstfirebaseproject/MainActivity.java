package com.gouda.vivek.firstfirebaseproject;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private static final String TAG = "MainActivity";

    private EditText emailEDTV;
    private EditText passwordEDTV;
    private Button loginButton;
    private Button signoutButton;
    private Button createButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEDTV = (EditText) findViewById(R.id.emailED);
        passwordEDTV = (EditText) findViewById(R.id.passwordED);
        loginButton = (Button) findViewById(R.id.loginButton);
        signoutButton = (Button) findViewById(R.id.signoutButton);
        createButton = (Button) findViewById(R.id.createAccButton);

        mAuth = FirebaseAuth.getInstance();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("message");

        databaseReference.setValue("Hello Firebase");
        //databaseReference.setValue("vivek");

//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//
//                String value = dataSnapshot.getValue(Customer.class);
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user!=null) {

                    Log.d(TAG,"user signed in:");
                    Log.d(TAG,"Username : "+user.getEmail());
                }
                else {

                    Log.d(TAG,"user signed out");
                }
            }
        };

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String email = emailEDTV.getText().toString();
                String password = passwordEDTV.getText().toString();

                if (!email.equals("") && !password.equals("")) {

                    mAuth.signInWithEmailAndPassword(email,password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {

                                        Toast.makeText(MainActivity.this, "Failed to sign in !!", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(MainActivity.this, "Signed in Successfully", Toast.LENGTH_SHORT).show();

                                        //now we can write to DB

                                        Customer customer = new Customer("Vivek","Gouda",email,20);
                                        databaseReference.setValue(customer);
                                        //databaseReference.setValue("Hey now I'm sign in !!");
                                    }
                                }
                            });
                }
            }
        });

        signoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Toast.makeText(MainActivity.this, "You Successfully signed out !!", Toast.LENGTH_SHORT).show();
            }
        });

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailEDTV.getText().toString();
                String password = passwordEDTV.getText().toString();

                if (!email.equals("") && !password.equals("")) {

                    mAuth.createUserWithEmailAndPassword(email,password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {

                                        Toast.makeText(MainActivity.this, "Failed to create account !!", Toast.LENGTH_SHORT).show();
                                    }else {
                                        Toast.makeText(MainActivity.this, "Account Created!!", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }

                }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mAuth.removeAuthStateListener(mAuthListener);
    }
}
