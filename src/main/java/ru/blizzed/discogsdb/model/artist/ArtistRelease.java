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

package ru.blizzed.discogsdb.model.artist;

import com.google.gson.annotations.SerializedName;

public class ArtistRelease {

    @SerializedName("artist")
    private String artist;

    @SerializedName("id")
    private long id;

    @SerializedName("main_release")
    private long mainRelease;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("role")
    private String role;

    @SerializedName("thumb")
    private String thumb;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    @SerializedName("year")
    private int year;

    @SerializedName("format")
    private String format;

    @SerializedName("label")
    private String label;

    @SerializedName("status")
    private String status;

    public String getArtist() {
        return artist;
    }

    public long getId() {
        return id;
    }

    public long getMainRelease() {
        return mainRelease;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getRole() {
        return role;
    }

    public String getThumb() {
        return thumb;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public int getYear() {
        return year;
    }

    public String getFormat() {
        return format;
    }

    public String getLabel() {
        return label;
    }

    public String getStatus() {
        return status;
    }
}
