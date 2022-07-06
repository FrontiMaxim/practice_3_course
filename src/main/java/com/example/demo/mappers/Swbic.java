package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;


@Data
@JsonRootName("SWBICS")
public class Swbic {

    @JsonProperty("SWBIC")
    private String swbic;

    @JsonProperty("DefaultSwbic")
    private Long defaultSwbic;
}
