package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;

public enum Type {
    @SerializedName("release")
    RELEASE,

    @SerializedName("master")
    MASTER,

    @SerializedName("artist")
    ARTIST,

    @SerializedName("label")
    LABEL;

    public String lower() {
        return name().toLowerCase();
    }

}
