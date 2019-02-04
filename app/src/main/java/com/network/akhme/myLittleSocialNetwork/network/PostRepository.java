package com.network.akhme.myLittleSocialNetwork.network;

import retrofit2.Callback;

public class PostRepository implements PostRepositoryInterface {

    public void getAllPosts(Callback callback){
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(callback);
    }

}