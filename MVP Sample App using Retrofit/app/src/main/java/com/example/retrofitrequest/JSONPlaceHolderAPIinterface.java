package com.example.retrofitrequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JSONPlaceHolderAPIinterface {
    @GET("/posts")
    Call<List<Post>> getAllUsers();

}
