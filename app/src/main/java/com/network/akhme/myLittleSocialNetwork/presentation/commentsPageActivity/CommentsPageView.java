package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import com.arellomobile.mvp.MvpView;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;

import java.util.ArrayList;

public interface CommentsPageView extends MvpView {

    void getClickedPost(int id);

    void getCommentsForPost(ArrayList<Comment> list);

}
