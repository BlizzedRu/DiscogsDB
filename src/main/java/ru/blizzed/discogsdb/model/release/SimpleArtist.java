
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class SimpleArtist {

    @SerializedName("anv")
    private String anv;

    @SerializedName("id")
    private long id;

    @SerializedName("join")
    private String join;

    @SerializedName("name")
    private String name;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("role")
    private String role;

    @SerializedName("tracks")
    private String tracks;

    public String getAnv() {
        return anv;
    }

    public long getId() {
        return id;
    }

    public String getJoin() {
        return join;
    }

    public String getName() {
        return name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getRole() {
        return role;
    }

    public String getTracks() {
        return tracks;
    }
}
