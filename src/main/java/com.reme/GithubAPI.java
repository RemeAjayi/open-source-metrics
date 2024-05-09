package com.reme;

import okhttp3.*;
import okhttp3.Authenticator;
import java.io.IOException;
import okhttp3.Credentials;
import org.jetbrains.annotations.NotNull;

public class GithubAPI {
    OkHttpClient client;
    String credential = "" ;//read from env var/github vars/kube
    String url = "https://api.github.com/repos/apache/spark/pulls?sort=created";

    public void Authenticate() {
        client = new OkHttpClient.Builder()
                .authenticator(new Authenticator() {
                    @Override public Request authenticate(Route route, @NotNull Response response) throws IOException {
                        if (response.request().header("Authorization") != null) {
                            return null; // Give up, we've already attempted to authenticate.
                        }

                        System.out.println("Authenticating for response: " + response);
                        System.out.println("Challenges: " + response.challenges());
//                        String credential = Credentials.basic("jesse", "password1");
                        return response.request().newBuilder()
                                .header("Authorization", "Bearer " + credential)
                                .build();
                    }
                })
                .build();
    }

    public void run() throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            System.out.println(response.body().string());
        }
    }
    private int responseCount(Response response) {
        int result = 1;
        while ((response = response.priorResponse()) != null) {
            result++;
        }
        return result;
    }
}
