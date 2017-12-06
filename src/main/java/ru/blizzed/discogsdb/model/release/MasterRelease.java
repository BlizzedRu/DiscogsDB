
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

package ru.blizzed.discogsdb.model.release;


import com.google.gson.annotations.SerializedName;
import ru.blizzed.discogsdb.model.Image;

import java.util.List;


public class MasterRelease {

    @SerializedName("styles")
    private List<String> styles;

    @SerializedName("genres")
    private List<String> genres;

    @SerializedName("videos")
    private List<Video> videos;

    @SerializedName("title")
    private String title;

    @SerializedName("main_release")
    private int mainRelease;

    @SerializedName("main_release_url")
    private String mainReleaseUrl;

    @SerializedName("uri")
    private String uri;

    @SerializedName("artists")
    private List<SimpleArtist> artists;

    @SerializedName("versions_url")
    private String versionsUrl;

    @SerializedName("year")
    private int year;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("tracklist")
    private List<Track> tracks;

    @SerializedName("id")
    private long id;

    @SerializedName("num_for_sale")
    private int numForSale;

    @SerializedName("lowest_price")
    private double lowestPrice;

    @SerializedName("data_quality")
    private String dataQuality;

    public List<String> getStyles() {
        return styles;
    }

    public List<String> getGenres() {
        return genres;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public String getTitle() {
        return title;
    }

    public int getMainRelease() {
        return mainRelease;
    }

    public String getMainReleaseUrl() {
        return mainReleaseUrl;
    }

    public String getUri() {
        return uri;
    }

    public List<SimpleArtist> getArtists() {
        return artists;
    }

    public String getVersionsUrl() {
        return versionsUrl;
    }

    public int getYear() {
        return year;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public long getId() {
        return id;
    }

    public int getNumForSale() {
        return numForSale;
    }

    public double getLowestPrice() {
        return lowestPrice;
    }

    public String getDataQuality() {
        return dataQuality;
    }
}
