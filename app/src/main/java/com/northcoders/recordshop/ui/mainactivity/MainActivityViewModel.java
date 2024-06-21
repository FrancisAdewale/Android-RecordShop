package com.northcoders.recordshop.ui.mainactivity;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.model.AlbumRepo;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

   private AlbumRepo albumRepo;

    public MainActivityViewModel(@NotNull Application application) {
        super(application);
        this.albumRepo = new AlbumRepo(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepo.getMutableLiveData();
    }

    public void postAlbum(Album album) {
        albumRepo.setMutableLiveData(album);
    }
}
