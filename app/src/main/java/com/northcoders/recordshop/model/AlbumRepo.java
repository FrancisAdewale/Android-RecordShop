package com.northcoders.recordshop.model;

import android.app.Application;
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
}
