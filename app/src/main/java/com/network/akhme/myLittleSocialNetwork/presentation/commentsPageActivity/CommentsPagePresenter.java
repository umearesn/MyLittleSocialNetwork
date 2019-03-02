package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.interactor.CommentsInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class CommentsPagePresenter extends MvpPresenter<CommentsPageView> {

    private CommentsInteractor commentsInteractor;

    @Inject
    CommentsPagePresenter(CommentsInteractor commentsInteractor){
        this.commentsInteractor = commentsInteractor;
    }

    public void providePostClicked(int id){
        commentsInteractor.getClickedPost(id, new CallbackInterface<Post>() {
            @Override
            public void onSuccess(ArrayList<Post> list) {}

            @Override
            public void onSuccess(Post temp) {
                getViewState().getClickedPost(temp);
            }
        });
    }

    public void provideComments(int id){
        commentsInteractor.getComments(id, new CallbackInterface<Comment>() {
            @Override
            public void onSuccess(ArrayList<Comment> list) {
                getViewState().getCommentsForPost(list);
            }

            @Override
            public void onSuccess(Comment temp) {

            }
        });
    }

}
