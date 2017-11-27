
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class Rating {

    @SerializedName("average")
    private double average;

    @SerializedName("count")
    private int count;

    public double getAverage() {
        return average;
    }

    public int getCount() {
        return count;
    }
}
