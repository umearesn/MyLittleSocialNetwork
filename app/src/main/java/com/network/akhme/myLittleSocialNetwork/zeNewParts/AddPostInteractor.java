package com.network.akhme.myLittleSocialNetwork.zeNewParts;

import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

public class AddPostInteractor {

    public void addPost(Post newPost, CallbackInterface<Post> callback){
        new NewNetworkRepositoryImplementation().addNewPost(newPost, callback);
    }

}
