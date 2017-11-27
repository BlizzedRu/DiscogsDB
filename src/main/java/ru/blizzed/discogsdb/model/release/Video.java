
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("description")
    private String description;

    @SerializedName("duration")
    private int duration;

    @SerializedName("embed")
    private Boolean embed;

    @SerializedName("title")
    private String title;

    @SerializedName("uri")
    private String uri;

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public Boolean getEmbed() {
        return embed;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }
}
