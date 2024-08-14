package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;

@Embeddable
@JsonIgnoreProperties("ignoreUnknown = true")
public class User {

    public User(String type) {
        this.type = type;
    }

    @JsonProperty("type")
    public String type;

    // Getter
    public String getType() {
        return type;
    }

    // Setter
    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                '}';
    }

}