package ru.blizzed.discogsdb.model.artist;

import com.google.gson.annotations.SerializedName;

public class ArtistRelease {

    @SerializedName("artist")
    private String artist;
    
    @SerializedName("id")
    private long id;
    
    @SerializedName("main_release")
    private long mainRelease;
    
    @SerializedName("resource_url")
    private String resourceUrl;
    
    @SerializedName("role")
    private String role;
    
    @SerializedName("thumb")
    private String thumb;
    
    @SerializedName("title")
    private String title;
    
    @SerializedName("type")
    private String type;
    
    @SerializedName("year")
    private int year;
    
    @SerializedName("format")
    private String format;
    
    @SerializedName("label")
    private String label;
    
    @SerializedName("status")
    private String status;

    public String getArtist() {
        return artist;
    }

    public long getId() {
        return id;
    }

    public long getMainRelease() {
        return mainRelease;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getRole() {
        return role;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public String getFormat() {
        return format;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }
}
