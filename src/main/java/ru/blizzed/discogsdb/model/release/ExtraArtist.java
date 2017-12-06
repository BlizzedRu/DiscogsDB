
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

public class ExtraArtist {

    @SerializedName("anv")
    private String anv;

    @SerializedName("id")
    private long id;

    @SerializedName("join")
    private String join;

    @SerializedName("name")
    private String name;

    @SerializedName("resource_url")
    private String resourceUrl;

    @SerializedName("role")
    private String role;

    @SerializedName("tracks")
    private String tracks;

    public String getAnv() {
        return anv;
    }

    public long getId() {
        return id;
    }

    public String getJoin() {
        return join;
    }

    public String getName() {
        return name;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public String getRole() {
        return role;
    }

    public String getTracks() {
        return tracks;
    }
}
