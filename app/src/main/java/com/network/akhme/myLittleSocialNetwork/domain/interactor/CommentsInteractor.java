package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import javax.inject.Inject;

public class CommentsInteractor {
    private NewNetworkRepository networkRepository;

    @Inject
    CommentsInteractor(NewNetworkRepository newNetworkRepository){
        this.networkRepository = newNetworkRepository;
    }

    public void getClickedPost(int id, CallbackInterface<Post> callback){
        networkRepository.getPostById(id, callback);
    }

    public void getComments(int id, CallbackInterface<Comment> callback){
        networkRepository.getComments(id, callback);
    }

}
