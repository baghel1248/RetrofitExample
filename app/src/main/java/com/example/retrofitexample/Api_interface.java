package com.example.retrofitexample;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.POST;

public interface Api_interface {
    @POST("/databaseFetch.php")
    Call<List<Student>> getData();
}
