package com.samseen.phoneauthdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManageOTPActivity extends AppCompatActivity {

    public static final String TAG = "ManageOTPActivity";

    EditText t2;
    Button b2;
    String phone_number;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_otp_activity);

        t2 = findViewById(R.id.t2);
        b2 = findViewById(R.id.verify_code_button);
        phone_number = getIntent().getStringExtra("mobile").toString();
        auth = FirebaseAuth.getInstance();

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "Phone number is: "+phone_number);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = auth.getCurrentUser();
        if(user != null) {
            sendToMain();
        }
    }

    private void sendToMain() {
        Intent mainIntent = new Intent(ManageOTPActivity.this, DashboardActivity.class);
        startActivity(mainIntent);
        finish();
    }
}