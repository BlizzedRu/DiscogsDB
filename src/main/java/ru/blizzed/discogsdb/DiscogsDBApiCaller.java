package ru.blizzed.discogsdb;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import ru.blizzed.discogsdb.model.CommunityReleaseRating;
import ru.blizzed.discogsdb.model.Page;
import ru.blizzed.discogsdb.model.SearchPage;
import ru.blizzed.discogsdb.model.artist.Artist;
import ru.blizzed.discogsdb.model.artist.ArtistRelease;
import ru.blizzed.discogsdb.model.label.Label;
import ru.blizzed.discogsdb.model.label.LabelRelease;
import ru.blizzed.discogsdb.model.release.MasterRelease;
import ru.blizzed.discogsdb.model.release.Release;
import ru.blizzed.discogsdb.model.release.UserReleaseRating;
import ru.blizzed.discogsdb.model.release.Version;
import ru.blizzed.discogsdb.model.search.BaseSearchResult;
import ru.blizzed.discogsdb.model.search.ReleaseSearchResult;

import java.util.Map;

public interface DiscogsDBApiCaller {

    /**
     * The Release resource represents a particular physical or digital object released by one or more Artists.
     */
    @GET("releases/{release_id}")
    Call<Release> getRelease(@Path("release_id") long releaseId);

    /**
     * The Release resource represents a particular physical or digital object released by one or more Artists.
     */
    @GET("releases/{release_id}")
    Call<Release> getRelease(@Path("release_id") long releaseId, @Query("curr_abbr") String currency);

    /**
     * The Release Rating endpoint retrieves, updates, or deletes the rating of a release for a given user.
     */
    @GET("releases/{release_id}/rating/{username}")
    Call<UserReleaseRating> getUserReleaseRating(@Path("release_id") long releaseId, @Path("username") String username);

    /**
     * Retrieves the community release rating average and count.
     */
    @GET("releases/{release_id}/rating")
    Call<CommunityReleaseRating> getCommunityReleaseRating(@Path("release_id") long releaseId);

    /**
     * The Master resource represents a set of similar Releases. Masters (also known as “master releases”)
     * have a “main release” which is often the chronologically earliest.
     */
    @GET("masters/{master_id}")
    Call<Page<MasterRelease>> getMasterRelease(@Path("master_id") long masterId);

    /**
     * Retrieves a list of all Releases that are versions of this master. Accepts Pagination parameters.
     */
    @GET("masters/{master_id}/versions")
    Call<Version> getMasterReleaseVersions(@Path("master_id") long masterId, @QueryMap Map<String, String> queryMap);

    /**
     * The Artist resource represents a person in the Discogs database who contributed to a Release in some capacity.
     */
    @GET("artists/{artist_id}")
    Call<Artist> getArtist(@Path("artist_id") long artistId);

    /**
     * Returns a list of Releases and Masters associated with the Artist. Accepts Pagination.
     */
    @GET("artists/{artist_id}/releases")
    Call<Page<ArtistRelease>> getArtistReleases(@Path("artist_id") long artistId, @QueryMap Map<String, String> queryMap);

    /**
     * The Label resource represents a label, company, recording studio, location, or other entity involved with Artists and Releases.
     * Labels were recently expanded in scope to include things that aren’t labels – the name is an artifact of this history.
     */
    @GET("labels/{label_id}")
    Call<Label> getLabel(@Path("label_id") long labelId);

    /**
     * Returns a list of Releases associated with the label. Accepts Pagination parameters.
     */
    @GET("labels/{label_id}/releases")
    Call<Page<LabelRelease>> getLabelReleases(@Path("label_id") long labelId, @QueryMap Map<String, String> queryMap);

    /**
     * Issue a search query to our database. This endpoint accepts pagination parameters
     */
    @GET("database/search")
    Call<SearchPage> search(@Query("key") String key, @Query("secret") String secret, @QueryMap Map<String, String> queryMap);

    @GET("database/search")
    Call<Page<BaseSearchResult>> searchArtist(@Query("key") String key, @Query("secret") String secret, @Query("type") String type, @QueryMap Map<String, String> queryMap);

    @GET("database/search")
    Call<Page<BaseSearchResult>> searchLabel(@Query("key") String key, @Query("secret") String secret, @Query("type") String type, @QueryMap Map<String, String> queryMap);

    @GET("database/search")
    Call<Page<ReleaseSearchResult>> searchRelease(@Query("key") String key, @Query("secret") String secret, @Query("type") String type, @QueryMap Map<String, String> queryMap);

    @GET("database/search")
    Call<Page<ReleaseSearchResult>> searchMaster(@Query("key") String key, @Query("secret") String secret, @Query("type") String type, @QueryMap Map<String, String> queryMap);

}
