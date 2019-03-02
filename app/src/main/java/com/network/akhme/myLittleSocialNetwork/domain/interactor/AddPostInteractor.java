package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NetworkRepository;

import javax.inject.Inject;

public class AddPostInteractor {

    private NetworkRepository networkRepository;

    @Inject
    AddPostInteractor(NetworkRepository networkRepository){
        this.networkRepository = networkRepository;
    }

    public void addPost(Post newPost, CallbackInterface<Post> callback){
        networkRepository.addNewPost(newPost, callback);
    }

}
