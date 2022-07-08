package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "account_status", schema = "public", catalog = "db_cb_russia")
public class AccountStatus {

    @Id
    @Column(name = "id_account_status", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccountStatus;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "id_account", nullable = false)
//    private Account account;
}
