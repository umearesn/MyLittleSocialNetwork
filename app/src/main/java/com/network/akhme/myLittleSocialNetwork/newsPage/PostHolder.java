package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.network.akhme.myLittleSocialNetwork.R;

public class PostHolder extends RecyclerView.ViewHolder {
    public TextView authorView;
    public TextView bodyView;
    public TextView titleView;
    public PostHolder(View postView) {
        super(postView);
        authorView = (TextView) postView.findViewById(R.id.postAuthor);
        titleView = (TextView) postView.findViewById(R.id.postTitle);
        bodyView = (TextView) postView.findViewById(R.id.postBody);
    }
}
