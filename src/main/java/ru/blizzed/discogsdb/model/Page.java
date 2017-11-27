package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page<ContentType> {

    @SerializedName("pagination")
    private Pagination pagination;

    @SerializedName(value = "release", alternate = {"results", "versions"}) // TODO: 27.11.2017 another types
    private List<ContentType> content;

    public Pagination getPagination() {
        return pagination;
    }

    public List<ContentType> getContent() {
        return content;
    }
    
}
