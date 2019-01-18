package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.network.akhme.myLittleSocialNetwork.R;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView authorView;
    public TextView contentView;
    public PostHolder(View postView) {
        super(postView);
        authorView = (TextView) postView.findViewById(R.id.postAuthor);
        contentView = (TextView) postView.findViewById(R.id.content);
    }
}
