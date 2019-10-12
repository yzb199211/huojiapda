package com.yyy.pda.interfaces;

import org.json.JSONException;

import java.io.IOException;

public interface ResponseListener {
        void onSuccess(String string)  ;//参数不知道怎么传可以先不传

        void onFail(IOException e);
    }