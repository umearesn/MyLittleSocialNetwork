package com.network.akhme.myLittleSocialNetwork.network;

import com.network.akhme.myLittleSocialNetwork.newsPage.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);

    @GET("/posts")
    public Call<ArrayList<Post>> getAllPosts();

    @POST("/posts")
    public Call<Post> addNewPost(@Body Post newPost);
}
