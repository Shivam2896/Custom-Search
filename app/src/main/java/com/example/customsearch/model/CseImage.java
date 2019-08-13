package com.example.customsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CseImage implements Parcelable {

    @SerializedName("src")
    @Expose
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    protected CseImage(Parcel in) {
        src = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(src);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CseImage> CREATOR = new Parcelable.Creator<CseImage>() {
        @Override
        public CseImage createFromParcel(Parcel in) {
            return new CseImage(in);
        }

        @Override
        public CseImage[] newArray(int size) {
            return new CseImage[size];
        }
    };
}