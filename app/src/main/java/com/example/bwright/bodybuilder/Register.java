package com.example.bwright.bodybuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseNetworkException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthRecentLoginRequiredException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private EditText password, confirm_pass, first_name, last_name, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("User is signed in", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("User is signed out", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        first_name = (EditText) findViewById(R.id.first_name);
        last_name = (EditText) findViewById(R.id.last_name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirm_pass = (EditText) findViewById(R.id.confirm_pass);


        Button button = (Button) findViewById(R.id.register);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                createNewUser(view);
            }
        });
    }

    public void clearFields() {
        first_name.getText().clear();
        last_name.getText().clear();
        email.getText().clear();
        password.getText().clear();

    }

    public void addUserToFirebase() {


    }

    public void createNewUser(View view) {
        if (first_name.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Type First Name", Toast.LENGTH_SHORT).show();
        }
        else if (last_name.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Type Last Name", Toast.LENGTH_SHORT).show();
        }
        else if (email.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Type Email", Toast.LENGTH_SHORT).show();
        }
        else if (password.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Type Password", Toast.LENGTH_SHORT).show();
        }
        else if (confirm_pass.getText().toString().equals("")) {
            Toast.makeText(Register.this, "Confirm Your Password", Toast.LENGTH_SHORT).show();
        }
        else if (!password.getText().toString().equals(confirm_pass.getText().toString())) {
            Toast.makeText(Register.this, "Passwords Don't Match", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Log.d("New User Created", "createUserWithEmail:onComplete:" + task.isSuccessful());

                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.

                            if (!task.isSuccessful()) {
                                if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                                    Toast.makeText(Register.this, "User with this email already exists.", Toast.LENGTH_SHORT).show();
                                }
                                else if (task.getException() instanceof FirebaseNetworkException) {
                                    Toast.makeText(Register.this, "Please Check Your Connection", Toast.LENGTH_SHORT).show();
                                }
                                else if (task.getException() instanceof FirebaseAuthWeakPasswordException) {
                                    Toast.makeText(Register.this, "Password not strong enough", Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    Toast.makeText(Register.this, "Authorization Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                                Date date = new Date();
                                Map<String, Object> map = new HashMap<String, Object>();
                                map.put("Name", first_name.getText().toString() + " " + last_name.getText().toString());
                                map.put("Email", email.getText().toString());
                                map.put("Password", email.getText().toString());

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("users");
                                myRef.child(mAuth.getCurrentUser().getUid()).updateChildren(map);

                                clearFields();
                                Intent intent = new Intent(Register.this, Login.class);
                                startActivity(intent);
                            }

                            // ...
                        }
                    });
        }

    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

}
