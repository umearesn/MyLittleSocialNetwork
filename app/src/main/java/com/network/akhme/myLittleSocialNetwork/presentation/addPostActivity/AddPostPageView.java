package com.network.akhme.myLittleSocialNetwork.presentation.addPostActivity;

import com.arellomobile.mvp.MvpView;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

public interface AddPostPageView extends MvpView {
    void addPost(Post post);
}
