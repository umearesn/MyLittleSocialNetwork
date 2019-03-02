package com.network.akhme.myLittleSocialNetwork.presentation.commentsPageActivity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.network.akhme.myLittleSocialNetwork.R;
import com.network.akhme.myLittleSocialNetwork.di.App;
import com.network.akhme.myLittleSocialNetwork.domain.model.Comment;
import com.network.akhme.myLittleSocialNetwork.domain.model.Post;

import java.util.ArrayList;

import javax.inject.Inject;

public class CommentsPageActivity extends MvpAppCompatActivity implements CommentsPageView  {

    @Inject
    @InjectPresenter
    CommentsPagePresenter commentsPagePresenter;

    @ProvidePresenter
    CommentsPagePresenter provideCommentsPresenter(){
        return this.commentsPagePresenter;
    }

    private CommentAdapter commentAdapter;
    private View postView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        App.getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_comments_page);
        int id = getIntent().getExtras().getInt("postId")+ 1;
        this.commentAdapter = new CommentAdapter();
        RecyclerView commentsRecycler = findViewById(R.id.commentsList);
        commentsRecycler.setAdapter(this.commentAdapter);
        commentsRecycler.setLayoutManager(new LinearLayoutManager(this));
        postView = findViewById(R.id.openedPost);
        commentsPagePresenter.providePostClicked(id);
        commentsPagePresenter.provideComments(id);
    }

    @Override
    public void getClickedPost(Post post) {
        final TextView author = postView.findViewById(R.id.postAuthor);
        author.setText(Integer.toString(post.getUserId()));
        final TextView title =  postView.findViewById(R.id.postTitle);
        title.setText(post.getTitle());
        final TextView body = postView.findViewById(R.id.postBody);
        body.setText(post.getBody());
    }

    @Override
    public void getCommentsForPost(ArrayList<Comment> list) {
        this.commentAdapter.getComments(list);
    }

}
