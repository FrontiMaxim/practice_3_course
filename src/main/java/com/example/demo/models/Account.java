package com.example.demo.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Account {
    private long idAccount;
    private String account;
    private String regulationAccountType;
    private Integer accountCbrbic;
    private Date dateIn;
    private String accountStatus;
    private Long idBicDirectoryEntry;

    @Id
    @Column(name = "id_account", nullable = false)
    public long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(long idAccount) {
        this.idAccount = idAccount;
    }

    @Basic
    @Column(name = "account", nullable = true, length = 20)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Basic
    @Column(name = "regulation_account_type", nullable = true, length = 4)
    public String getRegulationAccountType() {
        return regulationAccountType;
    }

    public void setRegulationAccountType(String regulationAccountType) {
        this.regulationAccountType = regulationAccountType;
    }

    @Basic
    @Column(name = "account_cbrbic", nullable = true)
    public Integer getAccountCbrbic() {
        return accountCbrbic;
    }

    public void setAccountCbrbic(Integer accountCbrbic) {
        this.accountCbrbic = accountCbrbic;
    }

    @Basic
    @Column(name = "date_in", nullable = true)
    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Basic
    @Column(name = "account_status", nullable = true, length = 4)
    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    @Basic
    @Column(name = "id_bic_directory_entry", nullable = true)
    public Long getIdBicDirectoryEntry() {
        return idBicDirectoryEntry;
    }

    public void setIdBicDirectoryEntry(Long idBicDirectoryEntry) {
        this.idBicDirectoryEntry = idBicDirectoryEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return idAccount == account1.idAccount && Objects.equals(account, account1.account) && Objects.equals(regulationAccountType, account1.regulationAccountType) && Objects.equals(accountCbrbic, account1.accountCbrbic) && Objects.equals(dateIn, account1.dateIn) && Objects.equals(accountStatus, account1.accountStatus) && Objects.equals(idBicDirectoryEntry, account1.idBicDirectoryEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccount, account, regulationAccountType, accountCbrbic, dateIn, accountStatus, idBicDirectoryEntry);
    }
}
