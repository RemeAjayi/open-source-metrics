package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;

@JsonIgnoreProperties("ignoreUnknown = true")
@Embeddable

public class Label {
    public Label() {}
    public Label(String name) {
        this.name = name;
    }
    @JsonProperty("name")
    private String name;

    // Getter
    public String getName() {
        return name;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }
}