package com.network.akhme.myLittleSocialNetwork.data.api;

import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {
    @GET("/posts/{id}")
    public Call<Post> getPostWithID(@Path("id") int id);

    @GET("/posts")
    public Call<ArrayList<Post>> getAllPosts();

    @GET("comments")
    public Call<ArrayList<Comment>> getComments(@Query("postId") int postId);

    @POST("/posts")
    public Call<Post> addNewPost(@Body Post newPost);
}
