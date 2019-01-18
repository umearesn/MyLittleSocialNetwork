package com.network.akhme.myLittleSocialNetwork.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUsage {

    public void getPosts() throws IOException {
        URL adress = new URL("https://jsonplaceholder.typicode.com/posts/1");
        String line = null;
        HttpURLConnection connect = (HttpURLConnection) adress.openConnection();
        connect.setRequestMethod("GET");
        int responseCode = connect.getResponseCode();

        if(responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(connect.getInputStream()));
            StringBuffer response = new StringBuffer();
            while( (line = in.readLine()) != null ) {
                response.append(line);
            }
            in.close();
            System.out.println(response.toString());
        } else {
            System.out.println("Fail");
        }

    }

}
