package com.network.akhme.myLittleSocialNetwork.data.repository;

import com.network.akhme.myLittleSocialNetwork.data.api.JSONPlaceHolderApi;
import com.network.akhme.myLittleSocialNetwork.data.api.NewNetworkService;
import com.network.akhme.myLittleSocialNetwork.domain.callback.CallbackInterface;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.domain.repository.NewNetworkRepository;

import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewNetworkRepositoryImplementation implements NewNetworkRepository {

    private JSONPlaceHolderApi api = NewNetworkService.getApi();

    @Inject
    public NewNetworkRepositoryImplementation(JSONPlaceHolderApi api){
        this.api = api;
    }

    @Override
    public void getAllPosts(final CallbackInterface<ArrayList<Post>> callback) {
        api.getAllPosts()
                .enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    @Override
    public void getComments(int position, final CallbackInterface<Comment> callback){
        api.getComments(position)
                .enqueue(new Callback<ArrayList<Comment>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                        callback.onSuccess(response.body());
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    @Override
    public void addNewPost(Post newPost, final CallbackInterface<Post> callback) {
        api.addNewPost(newPost)
                .enqueue(new Callback<Post>() {
                    @Override
                    public void onResponse(Call<Post> call, Response<Post> response) {
                        if(response.body() != null){
                            callback.onSuccess(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<Post> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

}
