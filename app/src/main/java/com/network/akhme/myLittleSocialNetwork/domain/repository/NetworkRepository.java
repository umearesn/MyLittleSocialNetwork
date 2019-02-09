package com.network.akhme.myLittleSocialNetwork.domain.repository;

import android.support.v7.widget.RecyclerView;

import com.network.akhme.myLittleSocialNetwork.presentation.view.listener.OnPostListener;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

public interface NetworkRepository {

    void getAllPosts(final RecyclerView feedRecycler, final OnPostListener onPostListener);

    void addNewPost(Post newPost);

    void getComments(final RecyclerView commentRecycler, int position);

}
