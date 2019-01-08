package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.network.akhme.mylittlesocialnetwork.R;

import java.util.ArrayList;

public class PostsPageActivity extends AppCompatActivity {

    private ArrayList<Post> postsFeed;
    private RecyclerView feedRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_page_activity);
        feedRecycler = findViewById(R.id.postsPage);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        PostsAdapter adapter = new PostsAdapter(Post.createPostsList(20));
        feedRecycler.setAdapter(adapter);
    }



}
