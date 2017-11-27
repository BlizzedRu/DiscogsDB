package ru.blizzed.discogsdb.model;

import com.google.gson.annotations.SerializedName;

public class Pagination {

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("itemsCount")
    private int itemsCount;

    @SerializedName("page")
    private int page;

    @SerializedName("urls")
    private Urls urls;

    @SerializedName("pagesCount")
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
