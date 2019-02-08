package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.network.akhme.myLittleSocialNetwork.R;

public class CommentHolder extends RecyclerView.ViewHolder {

    public TextView authorName;
    public TextView postName;
    public TextView postBody;

    public CommentHolder(View commentView) {
        super(commentView);
        authorName = (TextView) commentView.findViewById(R.id.commentAuthor);
        postName = (TextView) commentView.findViewById(R.id.commentName);
        postBody = (TextView) commentView.findViewById(R.id.commentBody);
    }

}
