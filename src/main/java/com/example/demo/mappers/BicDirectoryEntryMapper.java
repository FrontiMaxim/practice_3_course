package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.util.List;

@Data
@JsonRootName("BICDirectoryEntry")
public class BicDirectoryEntryMapper {

    @JsonProperty("BIC")
    private Long bic;

    @JsonProperty("ParticipantInfo")
    private List<ParticipantInfoMapper> listParticipantInfo;

    @JsonProperty("Accounts")
    private List<AccountMapper> listAccount;

    @JsonProperty("SWBICS")
    private List<SwbicMapper> listSwbic;
}
