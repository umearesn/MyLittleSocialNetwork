package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NetworkRepository;

import javax.inject.Inject;

public class CommentsPageInteractor {

    private NetworkRepository networkRepository;

    @Inject
    CommentsPageInteractor(NetworkRepository networkRepository){
        this.networkRepository = networkRepository;
    }

    public void getClickedPost(int id, CallbackInterface<Post> callback){
        networkRepository.getPostById(id, callback);
    }

    public void getComments(int id, CallbackInterface<Comment> callback){
        networkRepository.getComments(id, callback);
    }

}
