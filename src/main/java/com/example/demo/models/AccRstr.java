package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "acc_rstr", schema = "public", catalog = "db_cb_russia")
public class AccRstr {

    @Id
    @Column(name = "id_acc_rstr", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idAccRstr;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_acc_rstr_list", nullable = false)
    private AccRstrList accRstrList;
}
