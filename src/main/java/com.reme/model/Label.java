package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.Data;

@JsonIgnoreProperties("ignoreUnknown = true")
@Embeddable
@Data

public class Label {
    @JsonProperty("name")
    private String name;
}
