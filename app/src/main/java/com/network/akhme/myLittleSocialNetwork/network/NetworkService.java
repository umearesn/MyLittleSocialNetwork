package com.network.akhme.myLittleSocialNetwork.network;

import retrofit2.Retrofit;

public class NetworkService {
    private static NetworkService sInstance = null;

    public static NetworkService getInstance() {
        if(sInstance == null) {
            sInstance =new NetworkService();
        }
        return sInstance;
    }

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .build();
    }

    public JSONPlaceHolderApi getJSONApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

}