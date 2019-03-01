package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import javax.inject.Inject;

public class AddPostInteractor {

    private NewNetworkRepository newNetworkRepository;

    @Inject
    AddPostInteractor(NewNetworkRepository newNetworkRepository){
        this.newNetworkRepository = newNetworkRepository;
    }

    public void addPost(Post newPost, CallbackInterface<Post> callback){
        newNetworkRepository.addNewPost(newPost, callback);
    }

}
