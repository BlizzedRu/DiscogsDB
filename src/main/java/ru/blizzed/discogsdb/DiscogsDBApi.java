package ru.blizzed.discogsdb;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.blizzed.discogsdb.model.Currency;
import ru.blizzed.discogsdb.model.release.Release;

import java.io.IOException;
import java.lang.annotation.Annotation;

public class DiscogsDBApi {

    private static final String ROOT_URL = "https://api.discogs.com/database/";

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


    public boolean hasAuthData() {
        checkInit();
        return authData != null;
    }

    public DiscogsAuthData getAuthData() {
        checkInit();
        return instance.authData;
    }

    /**
     * Returns a full URL to the SongKick API service as {@link String}
     *
     * @return full URL to SongKick API
     */
    public String getRootUrl() {
        checkInit();
        return ROOT_URL;
    }

    Error parseError(ResponseBody responseBody) throws IOException {
        Converter<ResponseBody, Error> converter = retrofit.responseBodyConverter(Error.class, new Annotation[0]);
        return converter.convert(responseBody);
    }

    private static DiscogsDBApiCaller getCaller() {
        checkInit();
        return instance.caller;
    }

    private static void checkInit() {
        if (!isInitialized()) throw new RuntimeException("DiscogsDBApi must be initialized first.");
    }

}
