package com.network.akhme.myLittleSocialNetwork.network;

import android.support.v7.widget.RecyclerView;

import com.network.akhme.myLittleSocialNetwork.newsPage.Post;

import retrofit2.Callback;

public interface PostRepositoryInterface {

    public void getAllPosts(RecyclerView recycler);

    public void addNewPost(Post newPost);

}
