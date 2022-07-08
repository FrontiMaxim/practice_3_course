package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.sql.Date;


@Data
@JsonRootName("RstrList")
public class RstrListMapper {

    @JsonProperty("Rstr")
    private String rstr;

    @JsonProperty("RstrDate")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date rstrDate;
}