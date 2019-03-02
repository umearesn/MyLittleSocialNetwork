package com.network.akhme.myLittleSocialNetwork.data.api;

import com.network.akhme.myLittleSocialNetwork.domain.repository.NetworkRepository;
import com.network.akhme.myLittleSocialNetwork.data.repository.NetworkRepositoryImplementation;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NewNetworkService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    /*private static NewNetworkService sInstance = null;
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
    }*/


    public static JSONPlaceHolderApi getApi() {
        Retrofit mRetrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit.create(JSONPlaceHolderApi.class);
    }

    @Provides
    NetworkRepository provideNetworkRepository(){
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return new NetworkRepositoryImplementation(retrofit.create(JSONPlaceHolderApi.class));
    }

}
