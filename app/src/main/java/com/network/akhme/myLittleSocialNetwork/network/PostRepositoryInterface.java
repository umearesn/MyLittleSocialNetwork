package com.network.akhme.myLittleSocialNetwork.network;

import android.support.v7.widget.RecyclerView;

import com.network.akhme.myLittleSocialNetwork.newsPage.OnPostListener;
import com.network.akhme.myLittleSocialNetwork.newsPage.Post;
import com.network.akhme.myLittleSocialNetwork.newsPage.PostsPageActivity;

import java.util.ArrayList;

import retrofit2.Callback;
import retrofit2.http.POST;

public interface PostRepositoryInterface {

    public void getAllPosts(final RecyclerView feedRecycler, final OnPostListener onPostListener);

    public void addNewPost(Post newPost);

}
