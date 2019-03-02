package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.interactor.CommentsPageInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class CommentsPagePresenter extends MvpPresenter<CommentsPageView> {

    private CommentsPageInteractor commentsPageInteractor;

    @Inject
    CommentsPagePresenter(CommentsPageInteractor commentsPageInteractor){
        this.commentsPageInteractor = commentsPageInteractor;
    }

    public void providePostClicked(int id){
        commentsPageInteractor.getClickedPost(id, new CallbackInterface<Post>() {
            @Override
            public void onSuccess(ArrayList<Post> list) {}

            @Override
            public void onSuccess(Post temp) {
                getViewState().getClickedPost(temp);
            }
        });
    }

    public void provideComments(int id){
        commentsPageInteractor.getComments(id, new CallbackInterface<Comment>() {
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
