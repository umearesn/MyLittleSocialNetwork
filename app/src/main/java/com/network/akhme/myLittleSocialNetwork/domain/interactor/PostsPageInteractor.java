package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NetworkRepository;

import javax.inject.Inject;

public class PostsPageInteractor {

    private NetworkRepository networkRepository;

    @Inject
    PostsPageInteractor(NetworkRepository networkRepository){
        this.networkRepository = networkRepository;
    }

    public void getAllPosts(CallbackInterface<Post> callback){
        networkRepository.getAllPosts(callback);
    }

}
