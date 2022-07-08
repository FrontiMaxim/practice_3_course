package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@JsonRootName("ParticipantInfo")
public class ParticipantInfoMapper {

    @JsonProperty("NameP")
    private String nameP;

    @JsonProperty("CntrCd")
    private String cntrCd;

    @JsonProperty("Rgn")
    private String rgn;

    @JsonProperty("Ind")
    private String ind;

    @JsonProperty("Tnp")
    private String tnp;

    @JsonProperty("Nnp")
    private String nnp;

    @JsonProperty("Adr")
    private String adr;

    @JsonProperty("DateIn")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date dateIn;

    @JsonProperty("PtType")
    private String ptType;

    @JsonProperty("Srvcs")
    private String srvcs;

    @JsonProperty("XchType")
    private String xchType;

    @JsonProperty("UID")
    private Long uid;

    @JsonProperty("RstrList")
    private List<RstrListMapper> listRstrList;
}
