package com.network.akhme.myLittleSocialNetwork.data.api.newNetworkService;

import com.network.akhme.myLittleSocialNetwork.data.api.JSONPlaceHolderApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewNetworkService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    private static NewNetworkService sInstance = null;
    private static Retrofit mRetrofit;

    public static NewNetworkService getInstance() {
        if(sInstance == null) {
            sInstance = new NewNetworkService();
        }
        return sInstance;
    }

    private NewNetworkService(){
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static JSONPlaceHolderApi getApi() {
        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

}
