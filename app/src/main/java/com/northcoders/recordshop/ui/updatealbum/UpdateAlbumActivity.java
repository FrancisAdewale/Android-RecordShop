package com.northcoders.recordshop.ui.updatealbum;

import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandler clickHandler;
    private Album album;
    private final String KEY = "album";
    private MainActivityViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            album = getIntent().getParcelableExtra(KEY, Album.class);
            Log.i("Album", album.getAlbumTitle());
        }else {
            album = getIntent().getParcelableExtra(KEY);
        }

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        clickHandler = new UpdateAlbumClickHandler(album, viewModel,this);

        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_update_album
        );

        binding.setAlbum(album);

        clickHandler.onUpdate(binding.btnUpdateBook);
        clickHandler.onDelete(binding.btnDeleteBook);
        clickHandler.onReturn(binding.fab);






    }
}