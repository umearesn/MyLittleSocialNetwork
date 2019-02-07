package com.network.akhme.myLittleSocialNetwork.newsPage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.addPostPage.AddPostPage;
import com.network.akhme.myLittleSocialNetwork.network.PostRepository;

import java.util.ArrayList;

public class PostsPageActivity extends AppCompatActivity {

    private ArrayList<Post> feed;
    private RecyclerView feedRecycler;
    private OnPostListener onPostListener = new OnPostListener() {
        @Override
        public void onPostClick(int position) {
            feedRecycler.getAdapter().getItemId(position);
            Intent testIntent = new Intent(PostsPageActivity.this, AddPostPage.class);
            startActivity(testIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_page_activity);
        feedRecycler = findViewById(R.id.postsPage);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        new PostRepository().getAllPosts(this.feedRecycler, this.onPostListener);
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

    public OnPostListener getOnPostListener() {
        return onPostListener;
    }

    public RecyclerView getFeedRecycler(){
        return feedRecycler;
    }
}

