package ru.blizzed.discogsdb.model.search;

import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.Type;

public class BaseSearchResult {

    @SerializedName("thumb")
    private String thumbnail;

    private String title;

    private String uri;

    @SerializedName("resource_url")
    private String resourceUrl;

    private long id;

    private Type type;

    public String getThumbnail() {
        return thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getUri() {
        return uri;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public long getId() {
        return id;
    }

    public Type getType() {
        return type;
    }
}
