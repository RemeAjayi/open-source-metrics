package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties("ignoreUnknown = true")
public class PullRequest {

    @JsonProperty("id")
    String id;
    @JsonProperty("title")
    String title;
    @JsonProperty("labels")
    Label[] label_names;
    @JsonProperty("user")
    User user_type;
    @JsonProperty("url")
    String url;
    @JsonProperty("created_at")
    String created_at;
    @JsonProperty("updated_at")
    String updated_at;
    @JsonProperty("closed_at")
    String closed_at;
    @JsonProperty("merged_at")
    String merged_at;
    @JsonProperty("state")
    String state;
    @JsonProperty("body")
    String body;

//    @JsonProperty("labels")
//    private void mapLabelName(Map<String,Object[]> labels) {
//        List<String> temp = new ArrayList<String>();
//        for (Object[] labelArray : labels.values()) {
//            for (Object labelObject : labelArray) {
//                Map<String, String> label = (Map<String, String>) labelObject;
//                temp.add(label.get("name"));
//            }
//        }
//        this.label_names = temp.toArray(new String[0]);
//    }

//    @JsonProperty("user")
//    private void mapUserType(Map<String,Object> user) {
//        this.user_type = (String)user.get("type");
//    }


}


