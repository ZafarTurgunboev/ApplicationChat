package com.example.asuslaptop.applicationchat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.EditText;

import com.example.asuslaptop.applicationchat.comon.MyTextChangedListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.redmadrobot.inputmask.MaskedTextChangedListener;

import java.util.concurrent.TimeUnit;

public class RegActivity extends AppCompatActivity implements View.OnClickListener {

    private FloatingActionButton fab;
    private Intent intent;
    private android.support.v7.widget.Toolbar toolbar;
    private EditText etPhoneCode;
    private EditText etPhoneNumber;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reg_activity);

        toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);
        etPhoneCode = findViewById(R.id.et_phone_code);
        etPhoneNumber = findViewById(R.id.et_phone_number);
        etPhoneNumber.setInputType(InputType.TYPE_CLASS_NUMBER);
        etPhoneNumber.setKeyListener(DigitsKeyListener.getInstance("0123456789 -."));

        MaskedTextChangedListener.Companion
                .installOn(etPhoneNumber, "[00] [000] [00] [00]", new MaskedTextChangedListener.ValueListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onTextChanged(boolean b, String s) {
                        if (b) {
                            fab.setVisibility(View.VISIBLE);
                        } else {
                            fab.setVisibility(View.INVISIBLE);
                        }
                    }
                });

        etPhoneNumber.addTextChangedListener(new MyTextChangedListener(etPhoneNumber));

        fab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                etPhoneNumber.toString(),        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

                    }

                    @Override
                    public void onVerificationFailed(FirebaseException e) {
                    }

                    @Override
                    public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                    String token=s;

                    }

                    @Override
                    public void onCodeAutoRetrievalTimeOut(String s) {
                        super.onCodeAutoRetrievalTimeOut(s);
                    }
                });        // OnVerificationStateChangedCallbacks

    }
}
