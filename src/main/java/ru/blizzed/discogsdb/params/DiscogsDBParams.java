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

/**
 * Common parameters for DiscogsBD API methods
 *
 * @author BlizzedRu
 */
public final class DiscogsDBParams {

    private DiscogsDBParams() {
    }

    public static final Param<Integer> PAGE = new Param<>("page");
    public static final Param<Integer> PER_PAGE = new Param<>("per_page");
    public static final SortParam SORT = new SortParam();
    public static final SortOrderParam SORT_ORDER = new SortOrderParam();
    public static final TypeParam TYPE = new TypeParam();
    public static final Param<String> TITLE = new Param<>("title");
    public static final Param<String> RELEASE_TITLE = new Param<>("release_title");
    public static final Param<String> CREDIT = new Param<>("credit");
    public static final Param<String> ARTIST = new Param<>("artist");
    public static final Param<String> ANV = new Param<>("anv");
    public static final Param<String> LABEL = new Param<>("label");
    public static final Param<String> GENRE = new Param<>("genre");
    public static final Param<String> STYLE = new Param<>("style");
    public static final Param<String> COUNTRY = new Param<>("country");
    public static final Param<String> YEAR = new Param<>("year");
    public static final Param<String> FORMAT = new Param<>("format");
    public static final Param<String> CAT_NO = new Param<>("catno");
    public static final Param<String> BARCODE = new Param<>("barcode");
    public static final Param<String> TRACK = new Param<>("track");
    public static final Param<String> SUBMITTER = new Param<>("submitter");
    public static final Param<String> CONTRIBUTOR = new Param<>("contributor");
    public static final Param<String> QUERY = new Param<>("q");

}
