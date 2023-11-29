package lib.ui;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AuthAPI {

    public static void main(String[] args) throws IOException {
        String postUrl = "https://idev.etm.ru/api/ipro/user/login";
        HttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(postUrl);


        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("log", "51951tes"));
        params.add(new BasicNameValuePair("pwd", "gvuq3266"));
        httpPost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
        StringBuilder responseText = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseText.append(line);
        }

        JsonParser parser = new JsonParser();
        JsonObject jsonResponse = parser.parse(responseText.toString()).getAsJsonObject();

        String sessionId = jsonResponse.getAsJsonObject("data").get("session").getAsString();
        System.out.println("Session ID: " + sessionId);

        httpClient.getConnectionManager().shutdown();


    }
}