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
import ru.blizzed.discogsdb.model.Image;

import java.util.List;

public class Label {

    @SerializedName("profile")
    private String profile;

    @SerializedName("releases_url")
    private String releasesUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("contact_info")
    private String contactInfo;

    @SerializedName("uri")
    private String uri;

    @SerializedName("sublabels")
    private List<SubLabel> subLabels;

    @SerializedName("urls")
    private List<String> urls;

    @SerializedName("images")
    private List<Image> images;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("id")
    private int id;

    @SerializedName("data_quality")
    private String dataQuality;

    public String getProfile() {
        return profile;
    }

    public String getReleasesUrl() {
        return releasesUrl;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getUri() {
        return uri;
    }

    public List<SubLabel> getSubLabels() {
        return subLabels;
    }

    public List<String> getUrls() {
        return urls;
    }

    public List<Image> getImages() {
        return images;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public int getId() {
        return id;
    }

    public String getDataQuality() {
        return dataQuality;
    }

    public static class SubLabel {

        @SerializedName("resource_url")
        private String resourceUrl;

        @SerializedName("id")
        private long id;

        @SerializedName("name")
        private String name;

        public String getResourceUrl() {
            return resourceUrl;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

}
