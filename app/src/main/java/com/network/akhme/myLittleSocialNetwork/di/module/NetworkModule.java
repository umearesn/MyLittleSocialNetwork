package com.network.akhme.myLittleSocialNetwork.di.module;

import com.network.akhme.myLittleSocialNetwork.data.api.JSONPlaceHolderApi;
import com.network.akhme.myLittleSocialNetwork.data.repository.newRepositoryImplementation.NewNetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Provides
    NewNetworkRepository provideNewNetworkRepository() {

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return new NewNetworkRepositoryImplementation(retrofit.create(JSONPlaceHolderApi.class));
    }
}
