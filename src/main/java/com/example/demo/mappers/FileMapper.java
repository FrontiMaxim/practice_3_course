package com.example.demo.mappers;

import com.example.demo.models.Ed807;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("FileInfo")
public class FileMapper {

    @JsonProperty("IdFile")
    private Long idFile;

    @JsonProperty("NameFile")
    private String nameFile;

    @JsonProperty("ED807")
    private Ed807Mapper ed807Mapper;
}
