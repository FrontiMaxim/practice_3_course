package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.util.List;

@Data
@JsonRootName("ED807")
public class Ed807Mapper {

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
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date creationDateTime;

    @JsonProperty("InfoTypeCode")
    private String infoTypeCode;

    @JsonProperty("BusinessDay")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date businessDay;

    @JsonProperty("DirectoryVersion")
    private Long directoryVersion;

    @JsonProperty("BICDirectoryEntry")
    private List<BicDirectoryEntryMapper> listBicDirectoryEntry;
}
