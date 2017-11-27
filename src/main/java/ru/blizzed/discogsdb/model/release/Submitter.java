
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class Submitter {

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("username")
    private String username;

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getUsername() {
        return username;
    }
}
