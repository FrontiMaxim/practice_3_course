package com.example.demo.models;

import javax.persistence.*;


@Entity
@Table(name = "rstr", schema = "public", catalog = "db_cb_russia")
public class Rstr {
    @Id
    @Column(name = "id_rstr", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRstr;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name="id_rstr_list", nullable = false)
    private RstrList rstrList;
}


