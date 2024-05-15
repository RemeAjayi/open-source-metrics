package com.reme.model;

public class PullRequest {
   String id;
   String title;
   String label_name;
   String repo_name;
   String user_type;
   String created_at;
   String updated_at;
   String closed_at;
   String merged_at;
   String state;
   String body;

   public PullRequest(String id,
                      String title,
                      String label_name,
                      String repo_name,
                      String user_type,
                      String created_at,
                      String updated_at,
                      String closed_at,
                      String merged_at,
                      String state,
                      String body) {
      this.id = id;
      this.title = title;
      this.label_name = label_name;
      this.repo_name = repo_name;
      this.user_type = user_type;
      this.created_at = created_at;
      this.updated_at = updated_at;
      this.closed_at = closed_at;
      this.merged_at = merged_at;
      this.state = state;
      this.body = body;
   }
}


