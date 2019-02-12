package com.network.akhme.myLittleSocialNetwork.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.data.NetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

public class CommentsActivity extends AppCompatActivity {

    private RecyclerView commentsRecycler;
    private View postView;
    private Post openedPost;
    private NetworkRepositoryImplementation repo = new NetworkRepositoryImplementation();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        setContentView(R.layout.post_comments_page);
        commentsRecycler = findViewById(R.id.commentsList);
        commentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        repo.getComments(this.commentsRecycler, receivedIntent.
                getExtras().getInt("postId") + 1);


        postView = findViewById(R.id.openedPost);
        repo.getPostById(receivedIntent.getExtras().getInt("postId") + 1, postView);
    }

}
