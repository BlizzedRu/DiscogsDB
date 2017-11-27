package ru.blizzed.discogsdb.params;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ParamsConverter {

    public static Map<String, String> asMap(Param... params) {
        if (params == null) return Collections.emptyMap();
        Map<String, String> map = new LinkedHashMap<>();
        Arrays.stream(params).forEach(p -> map.put(p.name(), p.toString()));
        return map;
    }

}
