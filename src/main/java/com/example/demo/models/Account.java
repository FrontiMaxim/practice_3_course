package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "account", schema = "public", catalog = "db_cb_russia")
public class Account {

    @Id
    @Column(name = "id_account", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccount;

    @Basic
    @Column(name = "account", nullable = true, length = 20)
    private String account;

    @Basic
    @Column(name = "regulation_account_type", nullable = true, length = 4)
    private String regulationAccountType;

    @Basic
    @Column(name = "account_cbrbic", nullable = true)
    private Long accountCbrbic;

    @Basic
    @Column(name = "date_in", nullable = true)
    private Date dateIn;

    @ManyToOne
    @JoinColumn(name = "id_bic_directory_entry", nullable = false)
    private BicDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<AccountStatus> listAccountStatus;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<RegulationAccountType> listRegulationAccountType;

    @OneToMany(mappedBy = "account", fetch = FetchType.LAZY)
    private List<AccRstrList> listAccRstrList;
}
