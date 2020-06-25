package com.example.mvpexample;

import android.text.TextUtils;

public class MyPresenter implements MyContract.Presenter {

    private MyContract.View view;

    MyPresenter(MyContract.View view) {
        this.view = view;
    }

    @Override
    public void doLogin(String email, String password) {

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            view.validateLogin();
        }
        else{
            if(email.equals("shivi@gmail.com") && password.equals("123")){
                view.loginSuccess();
            }
            else{
                view.loginError();
            }
        }

    }
}