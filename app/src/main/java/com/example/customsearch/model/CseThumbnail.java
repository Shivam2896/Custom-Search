package com.example.customsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CseThumbnail implements Parcelable {

    @SerializedName("width")
    @Expose
    private String width;
    @SerializedName("height")
    @Expose
    private String height;
    @SerializedName("src")
    @Expose
    private String src;

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }


    protected CseThumbnail(Parcel in) {
        width = in.readString();
        height = in.readString();
        src = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(width);
        dest.writeString(height);
        dest.writeString(src);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<CseThumbnail> CREATOR = new Parcelable.Creator<CseThumbnail>() {
        @Override
        public CseThumbnail createFromParcel(Parcel in) {
            return new CseThumbnail(in);
        }

        @Override
        public CseThumbnail[] newArray(int size) {
            return new CseThumbnail[size];
        }
    };
}