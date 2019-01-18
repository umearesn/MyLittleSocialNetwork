package com.network.akhme.myLittleSocialNetwork.newsPage;

import com.network.akhme.myLittleSocialNetwork.network.ApiUsage;

import org.json.JSONObject;

import java.util.ArrayList;

public class Post {

    private String authorName;

    private String content;

    public String getAuthorName() {
        return authorName;
    }

    public String getContent() {
        return content;
    }

    public Post(String name, String text){
        this.authorName = name;
        this.content = text;
    }

    public static ArrayList<Post> createPostsList(int amount){
        ArrayList<Post> contacts = new ArrayList<Post>();
        ApiUsage downloader = new ApiUsage();
        for (int i = 1; i <= amount; i++) {
            JSONObject post = null;
            String postName = null;
            String postContent = null;
            try {
                post = downloader.getPosts();
                postName = post.getString("userID");
                postContent = post.getString("body");
            } catch (Exception error) {}
            contacts.add(new Post(postName, postContent));
        }
        return contacts;
    }

}
