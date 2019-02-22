package com.network.akhme.myLittleSocialNetwork.domain.interactor;


import android.content.Context;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import javax.inject.Inject;


public class AddPostInteractor {

    private NewNetworkRepository networkRepository;

    @Inject
    AddPostInteractor(NewNetworkRepository networkRepository){
        this.networkRepository = networkRepository;
    }

    public void addPost(Post newPost, CallbackInterface<Post> callback, Context context){
        networkRepository.addNewPost(newPost, callback, context);
    }

}
