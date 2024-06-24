package com.northcoders.recordshop.ui.mainactivity;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.northcoders.recordshop.R;
import com.northcoders.recordshop.databinding.AlbumItemBinding;
import com.northcoders.recordshop.model.Album;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static com.northcoders.recordshop.databinding.AlbumItemBinding.inflate;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.albumList = albumList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @NotNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        AlbumItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.album_item, viewGroup, false);
        return new AlbumViewHolder(binding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull AlbumViewHolder albumViewHolder, int i) {
        Album album = albumList.get(i);
        albumViewHolder.albumItemBinding.setAlbum(album);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class AlbumViewHolder extends RecyclerView.ViewHolder {

        private AlbumItemBinding albumItemBinding;

        public AlbumViewHolder(AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }

                }
            });

        }
    }
}
