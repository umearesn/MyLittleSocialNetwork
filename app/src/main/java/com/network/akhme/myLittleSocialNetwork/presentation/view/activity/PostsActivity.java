package com.network.akhme.myLittleSocialNetwork.presentation.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.data.NetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.presentation.view.listener.OnPostListener;

public class PostsActivity extends AppCompatActivity {

    private RecyclerView feedRecycler;
    private OnPostListener onPostListener = new OnPostListener() {
        @Override
        public void onPostClick(int position) {
            feedRecycler.getAdapter().getItemId(position);
            Intent testIntent = new Intent(PostsActivity.this, CommentsActivity.class);
            testIntent.putExtra("postId", position);
            /*View postView = feedRecycler.getLayoutManager().findViewByPosition(position);
            testIntent.putExtra("post", );*/
            startActivity(testIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_page_activity);
        feedRecycler = findViewById(R.id.postsPage);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        new NetworkRepositoryImplementation().getAllPosts(this.feedRecycler, this.onPostListener);

        final Button addPost = (Button) findViewById(R.id.addPost);
        addPost.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toAddPostPage = new Intent(PostsActivity.this,
                                AddPostActivity.class);
                        startActivity(toAddPostPage);
                    }
                });
    }

}

