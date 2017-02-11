package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class RegisterActivity extends Activity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etPhone;
    private EditText etConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etPhone = (EditText) findViewById(R.id.etPhone);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                }
            }
        };

    }

    public void register(View view) {

        String Email = etEmail.getText().toString().trim();
        String Phone = etPhone.getText().toString().trim();
        String Password = etPassword.getText().toString().trim();
        String ConfirmPass = etConfirmPassword.getText().toString().trim();

        boolean errors = false;
        if (etEmail.length() == 0) {
            etEmail.setError("email required");
            errors = true;
        }
        if (Phone.length() < 10) {
            etPhone.setError("Invalid Phone number");
            errors = true;
        }
        if (Password.length() < 6) {
            etPassword.setError("Minimum Password Size is 6");
            errors = true;
        }

        if (!ConfirmPass.equals(Password)) {
            etConfirmPassword.setError("Password did not Match");
            errors = true;
        }
        if (errors) {
            return;
        }

        mAuth.createUserWithEmailAndPassword(Email, Password)   //place user email id and password here
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            /*todo: show a message to display error during registeration*/
                        } else {
                            Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            RegisterActivity.this.finish();
                        }
                        // ...
                    }
                });

    }
}