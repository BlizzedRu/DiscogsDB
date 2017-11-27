package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Version {

    @SerializedName("catno")
    private String catNo;

    private String country;

    private String format;

    private long id;

    private String label;

    private String released;

    @SerializedName("resource_url")
    private String resourceUrl;

    private String status;

    @SerializedName("major_formats")
    private List<String> majorFormats;

    @SerializedName("thumb")
    private String thumbnail;

    private String title;

    public String getCatNo() {
        return catNo;
    }

    public void setCatNo(String catNo) {
        this.catNo = catNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getMajorFormats() {
        return majorFormats;
    }

    public void setMajorFormats(List<String> majorFormats) {
        this.majorFormats = majorFormats;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
