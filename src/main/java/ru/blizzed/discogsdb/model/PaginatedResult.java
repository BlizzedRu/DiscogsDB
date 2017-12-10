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

import com.google.gson.annotations.SerializedName;

public class PaginatedResult {

    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public static class Pagination {

        @SerializedName("per_page")
        private int perPage;

        @SerializedName(value = "itemsCount", alternate = "items")
        private int itemsCount;

        @SerializedName("page")
        private int page;

        @SerializedName("urls")
        private Urls urls;

        @SerializedName(value = "pagesCount", alternate = "pages")
        private int pagesCount;

        public int getPerPage() {
            return perPage;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public int getPage() {
            return page;
        }

        public Urls getUrls() {
            return urls;
        }

        public int getPagesCount() {
            return pagesCount;
        }

        public static class Urls {
            private String last;
            private String next;

            public String getLast() {
                return last;
            }

            public String getNext() {
                return next;
            }
        }

    }

}
