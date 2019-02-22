package com.network.akhme.myLittleSocialNetwork.domain.repository;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.view.listener.OnPostListener;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public interface NewNetworkRepository {

    void getAllPosts(CallbackInterface<ArrayList<Post>> callback);

    void addNewPost(Post post, CallbackInterface<Post> callback);

    void getComments(int position, CallbackInterface<Comment> callback);

}
