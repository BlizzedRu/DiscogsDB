package ru.blizzed.discogsdb.model.label;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.Image;

import java.util.List;

public class Label {

    @SerializedName("profile")
    private String profile;

    @SerializedName("releases_url")
    private String releasesUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("contact_info")
    private String contactInfo;

    @SerializedName("uri")
    private String uri;

    @SerializedName("sublabels")
    private List<SubLabel> subLabels;

    @SerializedName("urls")
    private List<String> urls;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("id")
    private int id;

    @SerializedName("data_quality")
    private String dataQuality;

    public String getProfile() {
        return profile;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getUri() {
        return uri;
    }

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public List<String> getUrls() {
        return urls;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public int getId() {
        return id;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public static class SubLabel {

        @SerializedName("resource_url")
        private String resourceUrl;

        @SerializedName("id")
        private long id;

        @SerializedName("name")
        private String name;

        public String getResourceUrl() {
            return resourceUrl;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}
