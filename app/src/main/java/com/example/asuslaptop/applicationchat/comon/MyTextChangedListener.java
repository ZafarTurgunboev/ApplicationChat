package com.example.asuslaptop.applicationchat.comon;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MyTextChangedListener implements TextWatcher {

    private EditText etNumber;

    public MyTextChangedListener(EditText etNumber) {
        this.etNumber = etNumber;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
