package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface AlbumApiService {

    @GET("albums?includeNonStock=true")
    Call<List<Album>> getAllAlbums();
}
