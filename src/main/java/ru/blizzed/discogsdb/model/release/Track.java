
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class Track {

    @SerializedName("duration")
    private String duration;

    @SerializedName("position")
    private String position;

    @SerializedName("title")
    private String title;

    @SerializedName("type_")
    private String type;

    public String getDuration() {
        return duration;
    }

    public String getPosition() {
        return position;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }
}
