/*
 * Copyright (c) 2017 BlizzedRu (Ivan Vlasov)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ru.blizzed.discogsdb.model.label;

import com.google.gson.annotations.SerializedName;

public class LabelRelease {

    @SerializedName("artist")
    private String artist;

    @SerializedName("catno")
    private String catNo;

    @SerializedName("format")
    private String format;

    @SerializedName("id")
    private long id;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("status")
    private String status;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("year")
    private int year;

    public String getArtist() {
        return artist;
    }

    public String getCatNo() {
        return catNo;
    }

    public String getFormat() {
        return format;
    }

    public long getId() {
        return id;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getStatus() {
        return status;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }
}
