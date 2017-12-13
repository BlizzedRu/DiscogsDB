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

    public static DiscogsDBCaller<Release> getRelease(long releaseId) {
        return new DiscogsDBCaller<>(getCaller().getRelease(releaseId));
    }

    public static DiscogsDBCaller<Release> getRelease(long releaseId, Currency currency) {
        return new DiscogsDBCaller<>(getCaller().getRelease(releaseId, currency.name()));
    }

    public static DiscogsDBCaller<UserReleaseRating> getUserReleaseRating(long releaseId, String username) {
        return new DiscogsDBCaller<>(getCaller().getUserReleaseRating(releaseId, username));
    }

    public static DiscogsDBCaller<CommunityReleaseRating> getCommunityReleaseRating(long releaseId) {
        return new DiscogsDBCaller<>(getCaller().getCommunityReleaseRating(releaseId));
    }

    public static DiscogsDBCaller<MasterRelease> getMasterRelease(long masterId) {
        return new DiscogsDBCaller<>(getCaller().getMasterRelease(masterId));
    }

    public static DiscogsDBCaller<Page<Version>> getMasterReleaseVersions(long releaseId, Param... params) {
        return new DiscogsDBCaller<>(getCaller().getMasterReleaseVersions(releaseId, ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Artist> getArtist(long artistId) {
        return new DiscogsDBCaller<>(getCaller().getArtist(artistId));
    }

    public static DiscogsDBCaller<Page<ArtistRelease>> getArtistReleases(long artistId, Param... params) {
        return new DiscogsDBCaller<>(getCaller().getArtistReleases(artistId, ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Label> getLabel(long labelId) {
        return new DiscogsDBCaller<>(getCaller().getLabel(labelId));
    }

    public static DiscogsDBCaller<Page<LabelRelease>> getLabelReleases(long labelId, Param... params) {
        return new DiscogsDBCaller<>(getCaller().getLabelReleases(labelId, ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<SearchPage> search(Param... params) {
        return new DiscogsDBCaller<>(getCaller().search(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Page<BaseSearchResult>> searchArtist(Param... params) {
        return new DiscogsDBCaller<>(getCaller().searchArtist(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.ARTIST.lower(), ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Page<BaseSearchResult>> searchLabel(Param... params) {
        return new DiscogsDBCaller<>(getCaller().searchLabel(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.LABEL.lower(), ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Page<ReleaseSearchResult>> searchRelease(Param... params) {
        return new DiscogsDBCaller<>(getCaller().searchRelease(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.RELEASE.lower(), ParamsConverter.asMap(params)));
    }

    public static DiscogsDBCaller<Page<ReleaseSearchResult>> searchMaster(Param... params) {
        return new DiscogsDBCaller<>(getCaller().searchMaster(getAuthData().getConsumerKey(), getAuthData().getConsumerSecret(), Type.MASTER.lower(), ParamsConverter.asMap(params)));
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
