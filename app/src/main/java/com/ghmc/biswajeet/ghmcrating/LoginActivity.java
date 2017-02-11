package com.ghmc.biswajeet.ghmcrating;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends Activity {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuthListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user!=null){
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));
                }
            }
        };
        mAuth = FirebaseAuth.getInstance();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void guest(View view) {
        startActivity(new Intent(this,HomeActivity.class));
    }

    public void register(View view) {
        startActivity(new Intent(this,RegisterActivity.class));
    }

    public void signin(View view) {

        final EditText email=(EditText)findViewById(R.id.Email);
        final EditText password = (EditText) findViewById(R.id.Password);


        if (email.getText().toString().trim().length() == 0) {
            email.setError("emailId Required");
            return;
        }

        if (password.getText().toString().length() == 0) {
            password.setError("password Required");
            return;
        }

        mAuth.signInWithEmailAndPassword(email.getText().toString().trim(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            email.setError("Invalid email or password");
                            password.setError("Invalid email or password");

                        }

                    }
                });

    }
}
