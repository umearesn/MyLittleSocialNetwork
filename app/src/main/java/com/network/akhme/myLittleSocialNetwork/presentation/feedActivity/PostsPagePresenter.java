package com.network.akhme.myLittleSocialNetwork.presentation.feedActivity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.interactor.PostsPageInteractor;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class PostsPagePresenter extends MvpPresenter<PostsPageView> {

    private PostsPageInteractor postsPageInteractor;

    @Inject
    PostsPagePresenter(PostsPageInteractor postsPageInteractor){
        this.postsPageInteractor = postsPageInteractor;
    }

    public void getPosts(){
        this.postsPageInteractor.getAllPosts(new CallbackInterface<Post>() {
            @Override
            public void onSuccess(ArrayList<Post> list) {
                getViewState().getAllPosts(list);
            }

            @Override
            public void onSuccess(Post temp) {

            }
        });
    }

}
