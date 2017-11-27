package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.release.Rating;

public class CommunityReleaseRating {

    private Rating rating;

    @SerializedName("release_id")
    private long releaseId;

    public Rating getRating() {
        return rating;
    }

    public long getReleaseId() {
        return releaseId;
    }
}
