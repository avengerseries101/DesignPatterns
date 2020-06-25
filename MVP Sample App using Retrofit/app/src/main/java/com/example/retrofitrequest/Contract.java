package com.example.retrofitrequest;

import java.util.List;

public interface Contract {

    interface View {
        void success();

        void error();
    }

    interface Presenter {
        void checkDataInPresenter(List<Post> list);
    }
}
