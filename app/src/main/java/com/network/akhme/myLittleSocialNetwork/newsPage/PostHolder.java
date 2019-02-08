package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.network.akhme.myLittleSocialNetwork.R;

public class PostHolder extends RecyclerView.ViewHolder implements OnClickListener {
    public TextView authorView;
    public TextView bodyView;
    public TextView titleView;
    public OnPostListener onPostListener;

    public PostHolder(View postView, OnPostListener onPostListener) {
        super(postView);
        authorView = (TextView) postView.findViewById(R.id.postAuthor);
        titleView = (TextView) postView.findViewById(R.id.postTitle);
        bodyView = (TextView) postView.findViewById(R.id.postBody);
        this.onPostListener = onPostListener;
        postView.setOnClickListener(this);
    }

    @Override
    public void onClick(View postView) {
        this.onPostListener.onPostClick(getAdapterPosition());
    }
}
