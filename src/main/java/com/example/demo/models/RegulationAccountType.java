package com.example.demo.models;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "regulation_account_type", schema = "public", catalog = "db_cb_russia")
public class RegulationAccountType {

    @Id
    @Column(name = "id_regulation_account_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRegulationAccountType;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;
}
