package com.example.apicall;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    //Call is a Retrofit class that manages the HTTP request and response cycle for you.
    @GET("todos/1")
    Call<PostPojo> getElement();
}
