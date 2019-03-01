package com.network.akhme.myLittleSocialNetwork.domain.interactor;

import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import javax.inject.Inject;

public class CommentsInteractor {
    private NewNetworkRepository networkRepository;

    @Inject
    CommentsInteractor(NewNetworkRepository newNetworkRepository){
        this.networkRepository = newNetworkRepository;
    }

    public void getPostClicked(){}

    public void getComments(int position, final CallbackInterface<Comment> callback){
        networkRepository.getComments(position, callback);
    }

}
