package com.northcoders.recordshop.model;


import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.northcoders.recordshop.BR;

public class Album extends BaseObservable implements Parcelable {
    public int albumId;
    public String albumTitle;
    public String artistName;
    public String genre;
    public String releaseDate;
    public String price;
    public String stockQuantity;

    public Album() {
    }

    public Album(
            int albumId,
            String albumTitle,
            String artistName,
            String genre,
            String releaseDate,
            String price,
            String stockQuantity) {

        this.albumId = albumId;
        this.albumTitle = albumTitle;
        this.artistName = artistName;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    protected Album(Parcel in) {
        albumId = in.readInt();
        albumTitle = in.readString();
        artistName = in.readString();
        genre = in.readString();
        releaseDate = in.readString();
        price = in.readString();
        stockQuantity = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

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
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        notifyPropertyChanged(BR.price);

    }

    @Bindable
    public String getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(String stockQuantity) {
        this.stockQuantity = stockQuantity;
        notifyPropertyChanged(BR.stockQuantity);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(albumId);
        dest.writeString(albumTitle);
        dest.writeString(artistName);
        dest.writeString(genre);
        dest.writeString(releaseDate);
        dest.writeString(price);
        dest.writeString(stockQuantity);
    }
}
