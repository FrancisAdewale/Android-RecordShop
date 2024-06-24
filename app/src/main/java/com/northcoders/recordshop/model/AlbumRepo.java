package com.northcoders.recordshop.model;

import android.app.Application;
import android.widget.Toast;
import androidx.lifecycle.MutableLiveData;
import com.northcoders.recordshop.service.AlbumApiService;
import com.northcoders.recordshop.service.RetrofitInstance;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class AlbumRepo {

    private MutableLiveData<List<Album>> mutableLiveData;
    Application application;

    public AlbumRepo(Application application) {

        this.application = application;
        this.mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {
        AlbumApiService albumApiService = RetrofitInstance.getService();
      Call<List<Album>> call =   albumApiService.getAllAlbums();
      call.enqueue(new Callback<List<Album>>() {
          @Override
          public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
              if (response.isSuccessful() && response.body() != null) {
                  mutableLiveData.setValue(response.body());
              }
          }

          @Override
          public void onFailure(Call<List<Album>> call, Throwable throwable) {

          }
      });

      return mutableLiveData;
    }

    public void setMutableLiveData(Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.postAlbum(album);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album successfully added",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                        "Error adding album",
                        Toast.LENGTH_SHORT).show();


            }
        });

    }

    public void updateMutableLiveData(long id, Album album) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.updateAlbum(id, album);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Updated Album",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {
                Toast.makeText(application.getApplicationContext(),
                        "Updated Album Failed",
                        Toast.LENGTH_SHORT).show();

            }
        });


    }

    public void deleteMutableLiveData(long id) {
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.deleteAlbum(id);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        "Album Deleted",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Album> call, Throwable throwable) {

            }
        });
    }
}
