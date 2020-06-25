package com.example.mvpexample;

public interface MyContract {

    interface View{
        void validateLogin();
        void loginSuccess();
        void loginError();
    }
    interface Presenter{
        void doLogin(String email,String Password);
    }
}