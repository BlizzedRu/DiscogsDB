
package ru.blizzed.discogsdb.model.release;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Community {

    @SerializedName("contributors")
    private List<Contributor> contributors;

    @SerializedName("data_quality")
    private String dataQuality;

    @SerializedName("have")
    private long have;

    @SerializedName("rating")
    private Rating rating;

    @SerializedName("status")
    private String status;

    @SerializedName("submitter")
    private Submitter submitter;

    @SerializedName("want")
    private int want;

    public List<Contributor> getContributors() {
        return contributors;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public long getHave() {
        return have;
    }

    public Rating getRating() {
        return rating;
    }

    public String getStatus() {
        return status;
    }

    public Submitter getSubmitter() {
        return submitter;
    }

    public int getWant() {
        return want;
    }
}
