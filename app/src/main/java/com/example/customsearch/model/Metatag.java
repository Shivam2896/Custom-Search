package com.example.customsearch.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Metatag implements Parcelable {

    @SerializedName("viewport")
    @Expose
    private String viewport;
    @SerializedName("apple-itunes-app")
    @Expose
    private String appleItunesApp;
    @SerializedName("apple-mobile-web-app-title")
    @Expose
    private String appleMobileWebAppTitle;
    @SerializedName("application-name")
    @Expose
    private String applicationName;
    @SerializedName("google")
    @Expose
    private String google;
    @SerializedName("mobile-web-app-capable")
    @Expose
    private String mobileWebAppCapable;
    @SerializedName("theme-color")
    @Expose
    private String themeColor;
    @SerializedName("og:title")
    @Expose
    private String ogTitle;
    @SerializedName("og:description")
    @Expose
    private String ogDescription;
    @SerializedName("og:image")
    @Expose
    private String ogImage;
    @SerializedName("og:locale")
    @Expose
    private String ogLocale;
    @SerializedName("og:url")
    @Expose
    private String ogUrl;
    @SerializedName("og:site_name")
    @Expose
    private String ogSiteName;
    @SerializedName("og:type")
    @Expose
    private String ogType;
    @SerializedName("twitter:card")
    @Expose
    private String twitterCard;
    @SerializedName("twitter:site")
    @Expose
    private String twitterSite;
    @SerializedName("dc.type")
    @Expose
    private String dcType;
    @SerializedName("dc.title")
    @Expose
    private String dcTitle;
    @SerializedName("dc.contributor")
    @Expose
    private String dcContributor;
    @SerializedName("dc.date")
    @Expose
    private String dcDate;
    @SerializedName("citation_patent_number")
    @Expose
    private String citationPatentNumber;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("referrer")
    @Expose
    private String referrer;
    @SerializedName("citation_pdf_url")
    @Expose
    private String citationPdfUrl;
    @SerializedName("format-detection")
    @Expose
    private String formatDetection;

    public String getViewport() {
        return viewport;
    }

    public void setViewport(String viewport) {
        this.viewport = viewport;
    }

    public String getAppleItunesApp() {
        return appleItunesApp;
    }

    public void setAppleItunesApp(String appleItunesApp) {
        this.appleItunesApp = appleItunesApp;
    }

    public String getAppleMobileWebAppTitle() {
        return appleMobileWebAppTitle;
    }

    public void setAppleMobileWebAppTitle(String appleMobileWebAppTitle) {
        this.appleMobileWebAppTitle = appleMobileWebAppTitle;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getGoogle() {
        return google;
    }

    public void setGoogle(String google) {
        this.google = google;
    }

    public String getMobileWebAppCapable() {
        return mobileWebAppCapable;
    }

    public void setMobileWebAppCapable(String mobileWebAppCapable) {
        this.mobileWebAppCapable = mobileWebAppCapable;
    }

    public String getThemeColor() {
        return themeColor;
    }

    public void setThemeColor(String themeColor) {
        this.themeColor = themeColor;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public String getOgDescription() {
        return ogDescription;
    }

    public void setOgDescription(String ogDescription) {
        this.ogDescription = ogDescription;
    }

    public String getOgImage() {
        return ogImage;
    }

    public void setOgImage(String ogImage) {
        this.ogImage = ogImage;
    }

    public String getOgLocale() {
        return ogLocale;
    }

    public void setOgLocale(String ogLocale) {
        this.ogLocale = ogLocale;
    }

    public String getOgUrl() {
        return ogUrl;
    }

    public void setOgUrl(String ogUrl) {
        this.ogUrl = ogUrl;
    }

    public String getOgSiteName() {
        return ogSiteName;
    }

    public void setOgSiteName(String ogSiteName) {
        this.ogSiteName = ogSiteName;
    }

    public String getOgType() {
        return ogType;
    }

    public void setOgType(String ogType) {
        this.ogType = ogType;
    }

    public String getTwitterCard() {
        return twitterCard;
    }

    public void setTwitterCard(String twitterCard) {
        this.twitterCard = twitterCard;
    }

    public String getTwitterSite() {
        return twitterSite;
    }

    public void setTwitterSite(String twitterSite) {
        this.twitterSite = twitterSite;
    }

    public String getDcType() {
        return dcType;
    }

    public void setDcType(String dcType) {
        this.dcType = dcType;
    }

    public String getDcTitle() {
        return dcTitle;
    }

    public void setDcTitle(String dcTitle) {
        this.dcTitle = dcTitle;
    }

    public String getDcContributor() {
        return dcContributor;
    }

    public void setDcContributor(String dcContributor) {
        this.dcContributor = dcContributor;
    }

    public String getDcDate() {
        return dcDate;
    }

    public void setDcDate(String dcDate) {
        this.dcDate = dcDate;
    }

    public String getCitationPatentNumber() {
        return citationPatentNumber;
    }

    public void setCitationPatentNumber(String citationPatentNumber) {
        this.citationPatentNumber = citationPatentNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReferrer() {
        return referrer;
    }

    public void setReferrer(String referrer) {
        this.referrer = referrer;
    }

    public String getCitationPdfUrl() {
        return citationPdfUrl;
    }

    public void setCitationPdfUrl(String citationPdfUrl) {
        this.citationPdfUrl = citationPdfUrl;
    }

    public String getFormatDetection() {
        return formatDetection;
    }

    public void setFormatDetection(String formatDetection) {
        this.formatDetection = formatDetection;
    }


    protected Metatag(Parcel in) {
        viewport = in.readString();
        appleItunesApp = in.readString();
        appleMobileWebAppTitle = in.readString();
        applicationName = in.readString();
        google = in.readString();
        mobileWebAppCapable = in.readString();
        themeColor = in.readString();
        ogTitle = in.readString();
        ogDescription = in.readString();
        ogImage = in.readString();
        ogLocale = in.readString();
        ogUrl = in.readString();
        ogSiteName = in.readString();
        ogType = in.readString();
        twitterCard = in.readString();
        twitterSite = in.readString();
        dcType = in.readString();
        dcTitle = in.readString();
        dcContributor = in.readString();
        dcDate = in.readString();
        citationPatentNumber = in.readString();
        title = in.readString();
        referrer = in.readString();
        citationPdfUrl = in.readString();
        formatDetection = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(viewport);
        dest.writeString(appleItunesApp);
        dest.writeString(appleMobileWebAppTitle);
        dest.writeString(applicationName);
        dest.writeString(google);
        dest.writeString(mobileWebAppCapable);
        dest.writeString(themeColor);
        dest.writeString(ogTitle);
        dest.writeString(ogDescription);
        dest.writeString(ogImage);
        dest.writeString(ogLocale);
        dest.writeString(ogUrl);
        dest.writeString(ogSiteName);
        dest.writeString(ogType);
        dest.writeString(twitterCard);
        dest.writeString(twitterSite);
        dest.writeString(dcType);
        dest.writeString(dcTitle);
        dest.writeString(dcContributor);
        dest.writeString(dcDate);
        dest.writeString(citationPatentNumber);
        dest.writeString(title);
        dest.writeString(referrer);
        dest.writeString(citationPdfUrl);
        dest.writeString(formatDetection);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Metatag> CREATOR = new Parcelable.Creator<Metatag>() {
        @Override
        public Metatag createFromParcel(Parcel in) {
            return new Metatag(in);
        }

        @Override
        public Metatag[] newArray(int size) {
            return new Metatag[size];
        }
    };
}