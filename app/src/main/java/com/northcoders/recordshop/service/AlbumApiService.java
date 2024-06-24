package com.northcoders.recordshop.service;

import com.northcoders.recordshop.model.Album;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface AlbumApiService {

    @GET("albums?includeNonStock=true")
    Call<List<Album>> getAllAlbums();

    @POST("albums")
    Call<Album> postAlbum(@Body Album album);

    @PUT("albums/{id}")
    Call<Album> updateAlbum(long id, @Body Album album);

    @DELETE("albums/{id}")
    Call<Album> deleteAlbum(long id);


}
