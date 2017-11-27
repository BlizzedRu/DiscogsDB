package ru.blizzed.discogsdb.model.release;

public class UserReleaseRating {

    private String username;
    private long release;
    private int rating;

    public String getUsername() {
        return username;
    }

    public long getRelease() {
        return release;
    }

    public int getRating() {
        return rating;
    }
}
