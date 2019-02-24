package com.network.akhme.myLittleSocialNetwork.zeNewParts;

import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

public interface NewNetworkRepository {

    void getAllPosts(CallbackInterface<ArrayList<Post>> callback);

    void addNewPost(Post post, CallbackInterface<Post> callback);

    void getComments(int position, CallbackInterface<Comment> callback);

}
