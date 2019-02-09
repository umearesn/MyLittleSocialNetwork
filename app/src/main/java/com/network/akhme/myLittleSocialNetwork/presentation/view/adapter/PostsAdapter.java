package com.network.akhme.myLittleSocialNetwork.presentation.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.view.listener.OnPostListener;
import com.network.akhme.myLittleSocialNetwork.presentation.view.holder.PostHolder;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostHolder> {

    private ArrayList<Post> postsFeed;
    private OnPostListener onPostListener;

    public PostsAdapter(ArrayList<Post> post, OnPostListener onPostListener){
        this.postsFeed = post;
        this.onPostListener = onPostListener;
    }


    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postsView = inflater.inflate(R.layout.post, parent, false);

        return new PostHolder(postsView, onPostListener);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position){
        Post post = postsFeed.get(position);
        holder.authorView.setText(((Integer) post.getUserId()).toString());
        holder.titleView.setText(post.getTitle());
        holder.bodyView.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return  postsFeed.size();
    }

    public Post getItem(int position) {
        return postsFeed.get(position);
    }

}
