package com.network.akhme.myLittleSocialNetwork.presentation.feedActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.di.App;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;
import com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity.CommentsPageActivity;
import com.network.akhme.myLittleSocialNetwork.presentation.addPostActivity.AddPostActivity;

import java.util.ArrayList;

import javax.inject.Inject;

public class PostsPageActivity extends MvpAppCompatActivity implements PostsPageView {

    @Inject
    @InjectPresenter
    PostsPagePresenter postsPagePresenter;

    @ProvidePresenter
    PostsPagePresenter providePostsPagePresenter(){
        return this.postsPagePresenter;
    }

    private RecyclerView feedRecycler;
    private PostsAdapter postsAdapter;
    private OnPostListener onPostListener = new OnPostListener() {
        @Override
        public void onPostClick(int position) {
            //feedRecycler.getAdapter().getItemId(position);
            Intent testIntent = new Intent(PostsPageActivity.this, CommentsPageActivity.class);
            testIntent.putExtra("postId", position);
            startActivity(testIntent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_page_activity);
        feedRecycler = findViewById(R.id.postsPage);
        this.postsAdapter = new PostsAdapter(onPostListener);
        feedRecycler.setAdapter(this.postsAdapter);
        feedRecycler.setLayoutManager(new LinearLayoutManager(this));
        this.postsPagePresenter.getPosts();
        final Button addPost = (Button) findViewById(R.id.addPost);
        addPost.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent toAddPostPage = new Intent(PostsPageActivity.this,
                                AddPostActivity.class);
                        startActivity(toAddPostPage);
                    }
                });
    }

    @Override
    public void presentNewPost(Post post) {

    }

    @Override
    public void getAllPosts(ArrayList<Post> feed) {
        this.postsAdapter.getPosts(feed);
    }
}

