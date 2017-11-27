package ru.blizzed.discogsdb.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReleaseSearchResult {

    @SerializedName("style")
    private List<String> styles;

    @SerializedName("thumb")
    private String thumbnail;

    @SerializedName("format")
    private List<String> formats;

    private String country;

    @SerializedName("barcode")
    private List<String> barcodes;

    private String uri;

    @SerializedName("label")
    private List<String> labels;

    @SerializedName("catno")
    private String catNo;

    private Integer year;

    @SerializedName("genre")
    private List<String> genres;

    private String title;

    @SerializedName("resource_url")
    private String resourceUrl;

    private Community community;

    private long id;

    public List<String> getStyles() {
        return styles;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public List<String> getFormats() {
        return formats;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public String getUri() {
        return uri;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getCatNo() {
        return catNo;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public String getTitle() {
        return title;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public long getId() {
        return id;
    }

    public static class Community {
        private int want;
        private int have;

        public int getWant() {
            return want;
        }

        public int getHave() {
            return have;
        }
    }

}
