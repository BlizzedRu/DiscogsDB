package ru.blizzed.discogsdb.model.artist;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.Image;

import java.util.List;

public class Artist {

    @SerializedName("namevariations")
    private List<String> nameVariations;
    
    @SerializedName("profile")   
    private String profile;

    @SerializedName("releases_url")   
    private String releasesUrl;

    @SerializedName("resource_url")   
    private String resourceUrl;

    @SerializedName("uri")   
    private String uri;

    @SerializedName("urls")   
    private List<String> urls;
    
    @SerializedName("data_quality")   
    private String dataQuality;

    @SerializedName("id")   
    private long id;

    @SerializedName("images")   
    private List<Image> images;
    
    @SerializedName("members")
    private List<Member> members;

    public List<String> getNameVariations() {
        return nameVariations;
    }

    public String getProfile() {
        return profile;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getUrls() {
        return urls;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public long getId() {
        return id;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Member> getMembers() {
        return members;
    }
}
