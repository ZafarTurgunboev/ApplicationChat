package com.example.asuslaptop.applicationchat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.asuslaptop.applicationchat.comon.MyTextChangedListener;
import com.redmadrobot.inputmask.MaskedTextChangedListener;

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

        MaskedTextChangedListener.Companion
                .installOn(etPhoneNumber, "[00] [000] [00] [00]", new MaskedTextChangedListener.ValueListener() {
                    @SuppressLint("RestrictedApi")
                    @Override
                    public void onTextChanged(boolean b, String s) {
                        if (etPhoneNumber.getText().toString().length() == 12) {
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
        intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
