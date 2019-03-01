package com.network.akhme.myLittleSocialNetwork.domain.repository;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.network.akhme.myLittleSocialNetwork.presentation.feedActivity.OnPostListener;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

public interface NetworkRepository {

    void getPostById(int id, final View postView);

    void getAllPosts(final RecyclerView feedRecycler, final OnPostListener onPostListener);

    void addNewPost(Post newPost, Context context);

    void getComments(final RecyclerView commentRecycler, int position);

}
