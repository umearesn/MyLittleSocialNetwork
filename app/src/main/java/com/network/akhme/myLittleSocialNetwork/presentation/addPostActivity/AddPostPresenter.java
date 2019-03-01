package com.network.akhme.myLittleSocialNetwork.presentation.addPostActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.interactor.AddPostInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class AddPostPresenter extends MvpPresenter<AddPostPageView> {

    private AddPostInteractor addPostInteractor;

    @Inject
    AddPostPresenter(AddPostInteractor addPostInteractor){
        this.addPostInteractor = addPostInteractor;
    }

    public void createPost(Post newPost) {
        addPostInteractor.addPost(newPost, new CallbackInterface<Post>() {
            @Override
            public void onSuccess(List<Post> list) {}

            @Override
            public void onSuccess(Post post) {
                getViewState().addPost(post);
            }

        });
    }


}
