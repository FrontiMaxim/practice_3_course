package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;


@Data
@JsonRootName("SWBICS")
public class SwbicMapper {

    @JsonProperty("SWBIC")
    private String swbic;

    @JsonProperty("DefaultSWBIC")
    private Long defaultSwbic;
}
