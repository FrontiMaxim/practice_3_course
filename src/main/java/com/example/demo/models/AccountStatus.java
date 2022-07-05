package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account_status", schema = "public", catalog = "db_cb_russia")
public class AccountStatus {
    private long idAccountStatus;
    private String code;
    private String name;
    private Long idAccount;

    @Id
    @Column(name = "id_account_status", nullable = false)
    public long getIdAccountStatus() {
        return idAccountStatus;
    }

    public void setIdAccountStatus(long idAccountStatus) {
        this.idAccountStatus = idAccountStatus;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_account", nullable = true)
    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountStatus that = (AccountStatus) o;
        return idAccountStatus == that.idAccountStatus && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(idAccount, that.idAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccountStatus, code, name, idAccount);
    }
}
