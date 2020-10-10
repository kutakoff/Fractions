package com.example.test.tools;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * Watcher для всех полей (для числителей и значменателей)
 */
public class EditTextWatcher implements TextWatcher {

    private final android.os.Handler handler = new android.os.Handler();
    private Runnable runnable;

    public EditTextWatcher(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        handler.postDelayed(runnable, 2000);
    }
}
