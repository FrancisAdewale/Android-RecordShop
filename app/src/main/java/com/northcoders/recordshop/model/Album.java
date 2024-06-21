package com.northcoders.recordshop.model;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.northcoders.recordshop.BR;

public class Album extends BaseObservable {
    public int albumId;
    public String albumTitle;
    public String artistName;
    public String genre;
    public String releaseDate;
    public int price;
    public int stockQuantity;

    public Album() {
    }

    public Album(
            int albumId,
            String albumTitle,
            String artistName,
            String genre,
            String releaseDate,
            int price,
            int stockQuantity) {

        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    @Bindable
    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
        notifyPropertyChanged(BR.albumId);

    }

    @Bindable
    public String getAlbumTitle() {
        return albumTitle;
    }

    public void setAlbumTitle(String albumTitle) {
        this.albumTitle = albumTitle;
        notifyPropertyChanged(BR.albumTitle);

    }

    @Bindable
    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
        notifyPropertyChanged(BR.artistName);

    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);

    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);

    }

    @Bindable
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
        notifyPropertyChanged(BR.price);

    }

    @Bindable
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }
}
