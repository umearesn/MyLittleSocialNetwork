package com.network.akhme.myLittleSocialNetwork.newsPage;

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
        for (int i = 1; i <= amount; i++) {
            contacts.add(new Post("Person " + i, "This is postold number " + i));
        }
        return contacts;
    }

}
