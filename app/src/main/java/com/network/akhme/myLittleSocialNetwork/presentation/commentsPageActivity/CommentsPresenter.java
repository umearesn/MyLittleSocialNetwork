package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.interactor.CommentsInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class CommentsPresenter extends MvpPresenter<CommentsPageView> {

    private CommentsInteractor commentsInteractor;

    @Inject
    CommentsPresenter(CommentsInteractor commentsInteractor){
        this.commentsInteractor = commentsInteractor;
    }

    public void providePostClicked(int id){

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
