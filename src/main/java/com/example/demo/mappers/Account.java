package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.sql.Date;

@Data
@JsonRootName("Account")
public class Account {

    @JsonProperty("Account")
    private String account;

    @JsonProperty("RegulationAccountType")
    private String regulationAccountType;

    @JsonProperty("AccountCBRBIC")
    private Long accountCbrbic;

    @JsonProperty("Account")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date dateIn;
}
