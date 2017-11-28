package ru.blizzed.discogsdb.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReleaseSearchResult extends BaseSearchResult {

    @SerializedName("style")
    private List<String> styles;

    @SerializedName("format")
    private List<String> formats;

    private String country;

    @SerializedName("barcode")
    private List<String> barcodes;

    @SerializedName("label")
    private List<String> labels;

    @SerializedName("catno")
    private String catNo;

    private Integer year;

    @SerializedName("genre")
    private List<String> genres;

    private Community community;

    public List<String> getStyles() {
        return styles;
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
