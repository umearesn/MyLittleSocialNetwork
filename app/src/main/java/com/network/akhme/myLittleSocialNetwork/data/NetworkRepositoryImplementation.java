package com.network.akhme.myLittleSocialNetwork.data;

import android.support.v7.widget.RecyclerView;

import com.network.akhme.myLittleSocialNetwork.domain.repository.NetworkRepository;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.presentation.view.adapter.CommentAdapter;
import com.network.akhme.myLittleSocialNetwork.presentation.view.listener.OnPostListener;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.view.adapter.PostsAdapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkRepositoryImplementation implements NetworkRepository {

    private static JSONPlaceHolderApi networkApi = NetworkService.getInstance().getJSONApi();

    public void getAllPosts(final RecyclerView feedRecycler, final OnPostListener onPostListener) {
        networkApi.getAllPosts()
                .enqueue(new Callback<ArrayList<Post>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                        feedRecycler.setAdapter(new PostsAdapter(response.body(), onPostListener));
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Post>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

    public void addNewPost(Post newPost) {
        NetworkService.getInstance()
                .getJSONApi()
                .addNewPost(newPost);
    }

    public void getComments(final RecyclerView commentRecycler, int postId){
        networkApi.getComments(postId)
                .enqueue(new Callback<ArrayList<Comment>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                        commentRecycler.setAdapter(new CommentAdapter(response.body()));
                    }

                    @Override
                    public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}

