package com.network.akhme.myLittleSocialNetwork.zeNewParts.addPostActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.zeNewParts.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.zeNewParts.AddPostInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.List;

@InjectViewState
public class AddPostPresenter extends MvpPresenter<AddPostPageView> {

    private AddPostInteractor addPostInteractor = new AddPostInteractor();

    public void createPost(Post newPost) {
        addPostInteractor.addPost(newPost, new CallbackInterface<Post>() {
            @Override
            public void onSuccess(List<Post> list) {}

            @Override
            public void onSuccess(Post post) {
                getViewState().addPost(post);
            }

            @Override
            public void onError(String message) {}
        });
    }


}
