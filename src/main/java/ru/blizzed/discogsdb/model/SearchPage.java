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
        return results.keySet()
                .stream()
                .filter(v -> v.getType().equals(Type.LABEL))
                .collect(Collectors.toList());
    }

    public List<BaseSearchResult> getAllArtists() {
        return results.keySet()
                .stream()
                .filter(v -> v.getType().equals(Type.ARTIST))
                .collect(Collectors.toList());
    }

    public List<ReleaseSearchResult> getAllReleases() {
        List<ReleaseSearchResult> releases = new ArrayList<>();
        results.keySet()
                .stream()
                .filter(v -> v.getType().equals(Type.RELEASE))
                .forEach(r -> releases.add((ReleaseSearchResult) r));
        return releases;
    }

    public List<ReleaseSearchResult> getAllMasters() {
        List<ReleaseSearchResult> releases = new ArrayList<>();
        results.keySet()
                .stream()
                .filter(v -> v.getType().equals(Type.MASTER))
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
