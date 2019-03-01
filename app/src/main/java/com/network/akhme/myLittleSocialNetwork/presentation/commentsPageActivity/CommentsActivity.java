package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.data.repository.NetworkRepositoryImplementation;
import com.network.akhme.myLittleSocialNetwork.di.App;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

public class CommentsActivity extends MvpAppCompatActivity implements CommentsPageView  {

    @Inject
    @InjectPresenter
    CommentsPresenter commentsPresenter;

    @ProvidePresenter
    CommentsPresenter provideCommentsPresenter(){
        return this.commentsPresenter;
    }

    private RecyclerView commentsRecycler;
    private CommentAdapter commentAdapter = new CommentAdapter();
    private View postView;
    private Post openedPost;
    private NetworkRepositoryImplementation repo = new NetworkRepositoryImplementation();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comments_page);
        Intent receivedIntent = getIntent();
        commentsRecycler = findViewById(R.id.commentsList);
        commentsRecycler.setAdapter(this.commentAdapter);
        commentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        commentsPresenter.provideComments(receivedIntent.getExtras().getInt("postId")+ 1);


        postView = findViewById(R.id.openedPost);
        repo.getPostById(receivedIntent.getExtras().getInt("postId") + 1, postView);
    }

    @Override
    public void getClickedPost() {

    }

    @Override
    public void getCommentsForPost(ArrayList<Comment> list) {
        this.commentAdapter.setComments(list);
    }

    /*@Override
    public void getCommentsForPost() {

    }*/
}
