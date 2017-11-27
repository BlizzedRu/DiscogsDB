package ru.blizzed.discogsdb.model.label;

import com.google.gson.annotations.SerializedName;

public class LabelRelease {

    @SerializedName("artist")
    private String artist;

    @SerializedName("catno")
    private String catNo;

    @SerializedName("format")
    private String format;

    @SerializedName("id")
    private long id;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("year")
    private int year;

    public String getArtist() {
        return artist;
    }

    public String getCatNo() {
        return catNo;
    }

    public String getFormat() {
        return format;
    }

    public long getId() {
        return id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
