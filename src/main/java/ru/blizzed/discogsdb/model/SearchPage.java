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

package ru.blizzed.discogsdb.model;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import ru.blizzed.discogsdb.model.search.BaseSearchResult;
import ru.blizzed.discogsdb.model.search.ReleaseSearchResult;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchPage extends PaginatedResult {

    @JsonAdapter(SearchResultsDeserializer.class)
    private Map<BaseSearchResult, Type> results;

    public Map<BaseSearchResult, Type> getResults() {
        return results;
    }

    public List<BaseSearchResult> getAllLabels() {
        return retrieveBasesByType(Type.LABEL);
    }

    public List<BaseSearchResult> getAllArtists() {
        return retrieveBasesByType(Type.ARTIST);
    }

    public List<ReleaseSearchResult> getAllReleases() {
        return retrieveReleasesByType(Type.RELEASE);
    }

    public List<ReleaseSearchResult> getAllMasters() {
        return retrieveReleasesByType(Type.MASTER);
    }

    private List<BaseSearchResult> retrieveBasesByType(Type type) {
        return results.keySet()
                .stream()
                .filter(v -> v.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<ReleaseSearchResult> retrieveReleasesByType(Type type) {
        List<ReleaseSearchResult> releases = new ArrayList<>();
        results.keySet()
                .stream()
                .filter(v -> v.getType().equals(type))
                .forEach(r -> releases.add((ReleaseSearchResult) r));
        return releases;
    }

    static class SearchResultsDeserializer implements JsonDeserializer<Map<BaseSearchResult, Type>> {
        @Override
        public Map<BaseSearchResult, Type> deserialize(JsonElement jsonElement, java.lang.reflect.Type type, JsonDeserializationContext context) throws JsonParseException {
            JsonArray array = jsonElement.getAsJsonArray();
            Map<BaseSearchResult, Type> results = new LinkedHashMap<>(array.size());
            array.forEach(element -> {
                JsonObject result = element.getAsJsonObject();
                String resultType = result.getAsJsonPrimitive("type").getAsString();
                if (resultType == null) return;
                Type realType = Type.valueOf(resultType.toUpperCase());
                switch (realType) {
                    case LABEL:
                    case ARTIST:
                        results.put(context.deserialize(result, BaseSearchResult.class), realType);
                        break;
                    case MASTER:
                    case RELEASE:
                        results.put(context.deserialize(result, ReleaseSearchResult.class), realType);
                        break;
                }
            });
            return results;
        }
    }

}
