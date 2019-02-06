package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.addPostPage.AddPostPage;
import com.network.akhme.myLittleSocialNetwork.network.PostRepository;

public class PostsPageActivity extends AppCompatActivity {

    private RecyclerView feedRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_page_activity);
        feedRecycler = findViewById(R.id.postsPage);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        new PostRepository().getAllPosts(this.feedRecycler);

        final Button addPost = (Button) findViewById(R.id.addPost);
        addPost.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toAddPostPage = new Intent(PostsPageActivity.this,
                                AddPostPage.class);
                        startActivity(toAddPostPage);
                    }
                });
    }
}

