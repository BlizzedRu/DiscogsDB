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
