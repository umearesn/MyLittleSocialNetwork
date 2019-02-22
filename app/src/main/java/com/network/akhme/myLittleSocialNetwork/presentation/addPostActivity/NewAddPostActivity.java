package com.network.akhme.myLittleSocialNetwork.presentation.addPostActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.data.repository.NetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.di.App;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.feedActivity.PostsPageActivity;
import com.network.akhme.myLittleSocialNetwork.presentation.view.activities.pages.AddPostActivity;

import javax.inject.Inject;

public class NewAddPostActivity extends MvpAppCompatActivity implements AddPostPageView {

    @Inject
    @InjectPresenter
    AddPostPresenter presenter;

    @ProvidePresenter
    AddPostPresenter provideAddPostPresenter(){
        return presenter;
    }

    EditText editTitle, editBody;
    Button sendNewPost;
    Post newPost;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_post_page);
        this.sendNewPost = findViewById(R.id.sendButton);
        this.editTitle = findViewById(R.id.editPostTitle);
        this.editBody = findViewById(R.id.editPostBody);
        sendNewPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newPost = new Post(0, 0,
                        editTitle.getText().toString(),
                        editBody.getText().toString());
                if (!newPost.getTitle().equals("") && !newPost.getBody().equals("")) {
                    presenter.createPost(newPost);
                }
                Intent toPostsPage = new Intent(NewAddPostActivity.this,
                        PostsPageActivity.class);
                startActivity(toPostsPage);
            }
        });
    }

    @Override
    public void addPost(Post newPost) {
        Intent intent = getIntent();
        intent.putExtra("POST", newPost);
        setResult(1, intent);
        finish();
    }

}
