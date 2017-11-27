
package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("height")
    private int height;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("type")
    private String type;

    @SerializedName("uri")
    private String uri;

    @SerializedName("uri150")
    private String uri150;

    @SerializedName("width")
    private int width;

    public int getHeight() {
        return height;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getType() {
        return type;
    }

    public String getUri() {
        return uri;
    }

    public String getUri150() {
        return uri150;
    }

    public int getWidth() {
        return width;
    }
}
