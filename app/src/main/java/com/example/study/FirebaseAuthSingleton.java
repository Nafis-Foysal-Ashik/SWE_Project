package com.example.study;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class FirebaseAuthSingleton {
    private static FirebaseAuthSingleton instance;
    private FirebaseAuth auth;

    private FirebaseAuthSingleton() {
        auth = FirebaseAuth.getInstance();
    }

    public static synchronized FirebaseAuthSingleton getInstance() {
        if (instance == null) {
            instance = new FirebaseAuthSingleton();
        }
        return instance;
    }

    public void signInWithEmailAndPassword(final Context context, String email, String password) {
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(context, "Log In Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(context, Homepage.class);
                            context.startActivity(intent);
                        } else {
                            Toast.makeText(context, "Log In failed. Please check your credentials.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
