package com.example.customsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hproduct implements Parcelable {

    @SerializedName("fn")
    @Expose
    private String fn;

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }


    protected Hproduct(Parcel in) {
        fn = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fn);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Hproduct> CREATOR = new Parcelable.Creator<Hproduct>() {
        @Override
        public Hproduct createFromParcel(Parcel in) {
            return new Hproduct(in);
        }

        @Override
        public Hproduct[] newArray(int size) {
            return new Hproduct[size];
        }
    };
}