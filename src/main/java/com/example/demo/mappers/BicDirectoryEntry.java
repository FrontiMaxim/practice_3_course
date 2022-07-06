package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

@Data
@JsonRootName("ED807")
public class BicDirectoryEntry {

    @JsonProperty("BIC")
    private Long bic;
}
