package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "acc_rstr_list", schema = "public", catalog = "db_cb_russia")
public class AccRstrList {

    @Id
    @Column(name = "id_acc_rstr_list", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAccRstrList;

    @Basic
    @Column(name = "acc_rstr", nullable = true, length = 20)
    private String accRstr;

    @Basic
    @Column(name = "acc_rstr_date", nullable = true)
    private Date accRstrDate;

    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Account account;

    @OneToMany(mappedBy = "accRstrList", fetch = FetchType.LAZY)
    private List<AccRstr> listAccRstr;
}
