package com.reme;



public class Main {

    public static void main(String[] args) {
        GithubAPI githubFetch = new GithubAPI();
        githubFetch.Authenticate();
        try {
            githubFetch.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}