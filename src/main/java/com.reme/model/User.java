package com.reme.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
@JsonIgnoreProperties("ignoreUnknown = true")
public class User {
    @JsonProperty("type")
    private String type;
}
