package ru.blizzed.discogsdb.model.artist;

import com.google.gson.annotations.SerializedName;

public class Member {

    @SerializedName("active")
    private boolean active;

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("resource_url")
    private String resourceUrl;

    public boolean isActive() {
        return active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }
}
