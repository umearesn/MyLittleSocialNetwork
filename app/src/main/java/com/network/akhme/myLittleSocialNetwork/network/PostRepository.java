package com.network.akhme.myLittleSocialNetwork.network;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import com.network.akhme.myLittleSocialNetwork.addPostPage.AddPostPage;
import com.network.akhme.myLittleSocialNetwork.newsPage.Post;
import com.network.akhme.myLittleSocialNetwork.newsPage.PostsAdapter;
import com.network.akhme.myLittleSocialNetwork.newsPage.PostsPageActivity;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository implements PostRepositoryInterface {

    public void getAllPosts(final RecyclerView feedRecycler) {
        NetworkService.getInstance()
                .getJSONApi()
                .getAllPosts()
                .enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        feedRecycler.setAdapter(new PostsAdapter(response.body()));
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public void addNewPost(Post newPost) {
        NetworkService.getInstance()
                .getJSONApi()
                .addNewPost(newPost);
    }
}

