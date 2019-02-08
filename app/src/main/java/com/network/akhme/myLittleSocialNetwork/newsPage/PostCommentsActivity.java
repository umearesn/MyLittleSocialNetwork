package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.network.PostRepository;

public class PostCommentsActivity extends AppCompatActivity {

    private RecyclerView commentsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent receivedIntent = getIntent();
        setContentView(R.layout.post_comments_page);
        commentsRecycler = findViewById(R.id.commentsList);
        commentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        new PostRepository().getComments(this.commentsRecycler, receivedIntent.
                getExtras().getInt("postId"));
    }

}
