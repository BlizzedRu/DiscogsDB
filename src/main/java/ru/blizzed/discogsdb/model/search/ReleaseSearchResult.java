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

package ru.blizzed.discogsdb.model.search;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReleaseSearchResult extends BaseSearchResult {

    @SerializedName("style")
    private List<String> styles;

    @SerializedName("format")
    private List<String> formats;

    private String country;

    @SerializedName("barcode")
    private List<String> barcodes;

    @SerializedName("label")
    private List<String> labels;

    @SerializedName("catno")
    private String catNo;

    private Integer year;

    @SerializedName("genre")
    private List<String> genres;

    private Community community;

    public List<String> getStyles() {
        return styles;
    }

    public List<String> getFormats() {
        return formats;
    }

    public String getCountry() {
        return country;
    }

    public List<String> getBarcodes() {
        return barcodes;
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getCatNo() {
        return catNo;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getGenres() {
        return genres;
    }

    public static class Community {
        private int want;
        private int have;

        public int getWant() {
            return want;
        }

        public int getHave() {
            return have;
        }
    }

}
