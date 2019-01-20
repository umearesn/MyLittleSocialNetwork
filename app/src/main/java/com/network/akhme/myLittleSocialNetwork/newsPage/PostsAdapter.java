package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.network.akhme.myLittleSocialNetwork.R;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostHolder>{

    private ArrayList<Post> postsFeed;

    public PostsAdapter(ArrayList<Post> post){
        postsFeed = post;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View postsView = inflater.inflate(R.layout.post, parent, false);

        return new PostHolder(postsView);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position){
        Post post = postsFeed.get(position);
        holder.authorView.setText(post.getUserId());
        holder.contentView.setText(post.getBody());
    }

    @Override
    public int getItemCount() {
        return  postsFeed.size();
    }

}
