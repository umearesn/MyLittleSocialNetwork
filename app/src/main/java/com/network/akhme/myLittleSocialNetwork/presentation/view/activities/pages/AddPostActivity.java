package com.network.akhme.myLittleSocialNetwork.presentation.view.activities.pages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.data.repository.NetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.feedActivity.PostsPageActivity;

public class AddPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post_page);

        final EditText editTitle = (EditText) findViewById(R.id.editPostTitle);
        final EditText editBody = (EditText) findViewById(R.id.editPostBody);

        final Button sendNewPost = (Button) findViewById(R.id.sendButton);
        sendNewPost.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Post newPost = new Post(0, 0,
                                editTitle.getText().toString(),
                                editBody.getText().toString());
                        new NetworkRepositoryImplementation().addNewPost(newPost, getApplicationContext());
                        Intent toPostsPage = new Intent(AddPostActivity.this,
                                PostsPageActivity.class);
                        startActivity(toPostsPage);
                    }
                });
    }
}
