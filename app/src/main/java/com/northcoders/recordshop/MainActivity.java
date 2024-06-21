package com.northcoders.recordshop;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.recordshop.databinding.ActivityMainBinding;
import com.northcoders.recordshop.model.Album;
import com.northcoders.recordshop.ui.mainactivity.AlbumAdapter;
import com.northcoders.recordshop.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;
    private ArrayList<Album> albumArrayList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        getAllAlbums();
    }

    private void getAllAlbums() {
        viewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {
            @Override
            public void onChanged(List<Album> albums) {
                albumArrayList = (ArrayList<Album>) albums;
                Log.i("aLBUM tITLE", albumArrayList.get(0).albumTitle);
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        albumAdapter = new AlbumAdapter(albumArrayList, this);
        binding.recyclerView.setAdapter(albumAdapter);
        binding.recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();
    }

}