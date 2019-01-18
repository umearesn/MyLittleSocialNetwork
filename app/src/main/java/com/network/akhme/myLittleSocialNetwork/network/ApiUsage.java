package com.network.akhme.myLittleSocialNetwork.network;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiUsage {

    public JSONObject getPosts() throws IOException {
        URL adress = new URL("https://jsonplaceholder.typicode.com/posts/1");
        HttpURLConnection connect = (HttpURLConnection) adress.openConnection();
        connect.setRequestMethod("GET");
        int responseCode = connect.getResponseCode();

        String line = null;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connect.getInputStream()));
            StringBuffer response = new StringBuffer();
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
            try {
                return new JSONObject(response.toString());
            } catch (Exception error) {
                return null;
            }
        } else {
            System.out.println("Fail");
            try {
                return new JSONObject().put("userID", "fail").put("body", "fail");
            } catch (Exception err) {
                return null;
            }
        }
    }

}
