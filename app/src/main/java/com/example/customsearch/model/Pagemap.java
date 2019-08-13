package com.example.customsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pagemap implements Parcelable {

    @SerializedName("cse_thumbnail")
    @Expose
    private List<CseThumbnail> cseThumbnail = null;
    @SerializedName("metatags")
    @Expose
    private List<Metatag> metatags = null;
    @SerializedName("cse_image")
    @Expose
    private List<CseImage> cseImage = null;
    @SerializedName("book")
    @Expose
    private List<Book> book = null;
    @SerializedName("product")
    @Expose
    private List<Product> product = null;
    @SerializedName("hproduct")
    @Expose
    private List<Hproduct> hproduct = null;

    public List<CseThumbnail> getCseThumbnail() {
        return cseThumbnail;
    }

    public void setCseThumbnail(List<CseThumbnail> cseThumbnail) {
        this.cseThumbnail = cseThumbnail;
    }

    public List<Metatag> getMetatags() {
        return metatags;
    }

    public void setMetatags(List<Metatag> metatags) {
        this.metatags = metatags;
    }

    public List<CseImage> getCseImage() {
        return cseImage;
    }

    public void setCseImage(List<CseImage> cseImage) {
        this.cseImage = cseImage;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public List<Hproduct> getHproduct() {
        return hproduct;
    }

    public void setHproduct(List<Hproduct> hproduct) {
        this.hproduct = hproduct;
    }


    protected Pagemap(Parcel in) {
        if (in.readByte() == 0x01) {
            cseThumbnail = new ArrayList<CseThumbnail>();
            in.readList(cseThumbnail, CseThumbnail.class.getClassLoader());
        } else {
            cseThumbnail = null;
        }
        if (in.readByte() == 0x01) {
            metatags = new ArrayList<Metatag>();
            in.readList(metatags, Metatag.class.getClassLoader());
        } else {
            metatags = null;
        }
        if (in.readByte() == 0x01) {
            cseImage = new ArrayList<CseImage>();
            in.readList(cseImage, CseImage.class.getClassLoader());
        } else {
            cseImage = null;
        }
        if (in.readByte() == 0x01) {
            book = new ArrayList<Book>();
            in.readList(book, Book.class.getClassLoader());
        } else {
            book = null;
        }
        if (in.readByte() == 0x01) {
            product = new ArrayList<Product>();
            in.readList(product, Product.class.getClassLoader());
        } else {
            product = null;
        }
        if (in.readByte() == 0x01) {
            hproduct = new ArrayList<Hproduct>();
            in.readList(hproduct, Hproduct.class.getClassLoader());
        } else {
            hproduct = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (cseThumbnail == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(cseThumbnail);
        }
        if (metatags == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(metatags);
        }
        if (cseImage == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(cseImage);
        }
        if (book == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(book);
        }
        if (product == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(product);
        }
        if (hproduct == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(hproduct);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Pagemap> CREATOR = new Parcelable.Creator<Pagemap>() {
        @Override
        public Pagemap createFromParcel(Parcel in) {
            return new Pagemap(in);
        }

        @Override
        public Pagemap[] newArray(int size) {
            return new Pagemap[size];
        }
    };
}