
package ru.blizzed.discogsdb.model.release;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Format {

    @SerializedName("descriptions")
    private List<String> descriptions;

    @SerializedName("name")
    private String name;

    @SerializedName("qty")
    private String qty;

    public List<String> getDescriptions() {
        return descriptions;
    }

    public String getName() {
        return name;
    }

    public String getQty() {
        return qty;
    }
}
