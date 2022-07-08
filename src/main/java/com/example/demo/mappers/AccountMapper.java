package com.example.demo.mappers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import javax.persistence.Basic;
import javax.persistence.Column;
import java.sql.Date;
import java.util.List;

@Data
@JsonRootName("Accounts")
public class AccountMapper {

    @JsonProperty("Account")
    private String account;

    @JsonProperty("RegulationAccountType")
    private String regulationAccountType;

    @JsonProperty("AccountCBRBIC")
    private Long accountCbrbic;

    @JsonProperty("DateIn")
    @JsonFormat(pattern="YYYY-MM-DD")
    private Date dateIn;

    @JsonProperty("CK")
    private Integer ck;

    @JsonProperty("AccountStatus")
    private String accountStatus;

    @JsonProperty("AccRstrList")
    private List<AccRstrListMapper> listAccRstrList;
}
