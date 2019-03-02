package com.network.akhme.myLittleSocialNetwork.presentation.feedActivity;

import com.arellomobile.mvp.MvpView;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

public interface PostsPageView extends MvpView {
    void presentNewPost(Post post);

    void getAllPosts(ArrayList<Post> feed);
}
