package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.network.akhme.myLittleSocialNetwork.R;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

    private ArrayList<Comment> commentsList;

    public CommentAdapter(ArrayList<Comment> comments){
        this.commentsList = comments;
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View commentsView = inflater.inflate(R.layout.comment, parent, false);
        return new CommentHolder(commentsView);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        Comment comment = commentsList.get(position);
        holder.authorName.setText(comment.getEmail());
        holder.commentName.setText(comment.getName());
        holder.commentBody.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        return commentsList.size();
    }
}
