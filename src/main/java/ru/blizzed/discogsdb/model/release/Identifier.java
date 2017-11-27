
package ru.blizzed.discogsdb.model.release;

import com.google.gson.annotations.SerializedName;

public class Identifier {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private String value;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
