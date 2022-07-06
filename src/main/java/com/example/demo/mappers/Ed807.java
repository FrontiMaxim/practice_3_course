package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.sql.Date;

@Data
@JsonRootName("ED807")
public class Ed807 {

    @JsonProperty("EDNo")
    private Long edNo;

    @JsonProperty("xmlns")
    private String xmlns;

    @JsonProperty("EDDate")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date edDate;

    @JsonProperty("EDAuthor")
    private Long edAuthor;

    @JsonProperty("CreationReason")
    private String creationReason;

    @JsonProperty("CreationDateTime")
    @JsonFormat(pattern="YYYY-MM-DDThh:mm:ssZ")
    private Date creationDateTime;

    @JsonProperty("InfoTypeCode")
    private String infoTypeCode;

    @JsonProperty("BusinessDay")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date businessDay;

    @JsonProperty("DirectoryVersion")
    private Long directoryVersion;
}
