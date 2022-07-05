package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "acc_rstr_list", schema = "public", catalog = "db_cb_russia")
public class AccRstrList {
    private long idAccRstrList;
    private String accRstr;
    private Date accRstrDate;
    private Long idAccount;

    @Id
    @Column(name = "id_acc_rstr_list", nullable = false)
    public long getIdAccRstrList() {
        return idAccRstrList;
    }

    public void setIdAccRstrList(long idAccRstrList) {
        this.idAccRstrList = idAccRstrList;
    }

    @Basic
    @Column(name = "acc_rstr", nullable = true, length = 4)
    public String getAccRstr() {
        return accRstr;
    }

    public void setAccRstr(String accRstr) {
        this.accRstr = accRstr;
    }

    @Basic
    @Column(name = "acc_rstr_date", nullable = true)
    public Date getAccRstrDate() {
        return accRstrDate;
    }

    public void setAccRstrDate(Date accRstrDate) {
        this.accRstrDate = accRstrDate;
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
        AccRstrList that = (AccRstrList) o;
        return idAccRstrList == that.idAccRstrList && Objects.equals(accRstr, that.accRstr) && Objects.equals(accRstrDate, that.accRstrDate) && Objects.equals(idAccount, that.idAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccRstrList, accRstr, accRstrDate, idAccount);
    }
}
