package com.sneha.retrofitexample;

import com.sneha.retrofitexample.model.RetroPhoto;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {
    @GET("/photos")
    Call<List<RetroPhoto>> getAllPhotos();
}
