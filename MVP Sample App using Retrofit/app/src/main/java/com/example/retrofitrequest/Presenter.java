package com.example.retrofitrequest;

import android.text.TextUtils;

import java.util.List;

public class Presenter implements Contract.Presenter {

    private Contract.View view;

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void checkDataInPresenter(List<Post> posts) {
        if(TextUtils.isEmpty(posts.toString()))
            view.error();
        else
            view.success();
    }
}
