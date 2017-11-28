package ru.blizzed.discogsdb;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.blizzed.discogsdb.model.*;
import ru.blizzed.discogsdb.model.Error;
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
import ru.blizzed.discogsdb.params.Param;
import ru.blizzed.discogsdb.params.ParamsConverter;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class DiscogsDBApi {

    private static final String ROOT_URL = "https://api.discogs.com/";

    private static DiscogsDBApi instance;

    private DiscogsAuthData authData;
    private DiscogsDBApiCaller caller;
    private Retrofit retrofit;

    private DiscogsDBApi(DiscogsAuthData authData) {
        this.authData = authData;

        retrofit = new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        caller = retrofit.create(DiscogsDBApiCaller.class);
    }

    public static DiscogsDBApi getInstance() {
        checkInit();
        return instance;
    }

    public static void initialize(DiscogsAuthData discogsAuthData) {
        if (instance == null)
            instance = new DiscogsDBApi(discogsAuthData);
    }

    public static void initialize() {
        initialize(null);
    }

    /**
     * Checks if you (or someone else) initialized DiscogsDBApi
     *
     * @return true if DiscogsDBApi is initialized
     */
    public static boolean isInitialized() {
        return instance != null;
    }


    /** Methods **/

    public static ApiCaller<Release> getRelease(long releaseId) {
        return new ApiCaller<>(getCaller().getRelease(releaseId));
    }

    public static ApiCaller<Release> getRelease(long releaseId, Currency currency) {
        return new ApiCaller<>(getCaller().getRelease(releaseId, currency.name()));
    }

    public static ApiCaller<UserReleaseRating> getUserReleaseRating(long releaseId, String username) {
        return new ApiCaller<>(getCaller().getUserReleaseRating(releaseId, username));
    }

    public static ApiCaller<CommunityReleaseRating> getCommunityReleaseRating(long releaseId) {
        return new ApiCaller<>(getCaller().getCommunityReleaseRating(releaseId));
    }

    public static ApiCaller<Page<MasterRelease>> getMasterRelease(long masterId) {
        return new ApiCaller<>(getCaller().getMasterRelease(masterId));
    }

    public static ApiCaller<Version> getMasterReleaseVersions(long releaseId, Param... params) {
        return new ApiCaller<>(getCaller().getMasterReleaseVersions(releaseId, ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Artist> getArtist(long artistId) {
        return new ApiCaller<>(getCaller().getArtist(artistId));
    }

    public static ApiCaller<Page<ArtistRelease>> getArtistReleases(long artistId, Param... params) {
        return new ApiCaller<>(getCaller().getArtistReleases(artistId, ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Label> getLabel(long labelId) {
        return new ApiCaller<>(getCaller().getLabel(labelId));
    }

    public static ApiCaller<Page<LabelRelease>> getLabelReleases(long labelId, Param... params) {
        return new ApiCaller<>(getCaller().getLabelReleases(labelId, ParamsConverter.asMap(params)));
    }

    public static ApiCaller<SearchPage> search(Param... params) {
        return new ApiCaller<>(getCaller().search(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Page<BaseSearchResult>> searchArtist(Param... params) {
        return new ApiCaller<>(getCaller().searchArtist(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.ARTIST.lower(), ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Page<BaseSearchResult>> searchLabel(Param... params) {
        return new ApiCaller<>(getCaller().searchLabel(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.LABEL.lower(), ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Page<ReleaseSearchResult>> searchRelease(Param... params) {
        return new ApiCaller<>(getCaller().searchRelease(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.RELEASE.lower(), ParamsConverter.asMap(params)));
    }

    public static ApiCaller<Page<ReleaseSearchResult>> searchMaster(Param... params) {
        return new ApiCaller<>(getCaller().searchMaster(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.MASTER.lower(), ParamsConverter.asMap(params)));
    }


    public void setAuthData(DiscogsAuthData authData) {
        this.authData = authData;
    }

    Error parseError(ResponseBody responseBody) throws IOException {
        Converter<ResponseBody, Error> converter = retrofit.responseBodyConverter(Error.class, new Annotation[0]);
        return converter.convert(responseBody);
    }

    private static DiscogsAuthData getAuthData() {
        checkInit();
        checkAuth();
        return instance.authData;
    }

    private static DiscogsDBApiCaller getCaller() {
        checkInit();
        return instance.caller;
    }

    private static boolean hasAuthData() {
        checkInit();
        return instance.authData != null;
    }

    private static void checkInit() {
        if (!isInitialized()) throw new RuntimeException("DiscogsDBApi must be initialized first.");
    }

    private static void checkAuth() {
        if (!hasAuthData()) throw new RuntimeException("You must set authentication data to use search method.");
    }

}
