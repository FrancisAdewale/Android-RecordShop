package com.northcoders.recordshop.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.MainActivity;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.Objects;

import static androidx.core.content.ContextCompat.startActivity;


public class UpdateAlbumClickHandler {

    private Album album;
    private MainActivityViewModel viewModel;
    private long id;
    private Context context;

    public UpdateAlbumClickHandler(Album album, MainActivityViewModel viewModel, Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void onUpdate(View view) {

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(
                        Objects.equals(album.getAlbumTitle(),"") || Objects.equals(album.getGenre(),"")
                                || Objects.equals(album.getArtistName(),"") ||
                                Objects.equals(album.getStockQuantity(),"") ||
                                Objects.equals(album.getPrice(),"") || Objects.equals(album.getReleaseDate(),"")
                ) {
                    Toast.makeText(context,"All fields must be filled", Toast.LENGTH_SHORT).show();
                } else {
                    id = album.getAlbumId();;
                    viewModel.updateAlbum(id, album);
                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(context,intent, null);
                }
            }
        });

    }

    public void onDelete(View view){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.deleteAlbum(id);
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(context,intent, null);
            }
        });

    }

    public void onReturn(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(context,intent, null);
            }
        });
    }
}
