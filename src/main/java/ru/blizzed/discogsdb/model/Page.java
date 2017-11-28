package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Page<ContentType> extends PaginatedResult {

    @SerializedName(value = "release", alternate = {"results", "versions"})
    private List<ContentType> content;

    public List<ContentType> getContent() {
        return content;
    }
    
}
