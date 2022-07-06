package com.example.demo.models;

import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "rstr_list", schema = "public", catalog = "db_cb_russia")
public class RstrList {

    @Id
    @Column(name = "id_rstr_list", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRstrList;

    @Basic
    @Column(name = "rstr", nullable = true, length = 4)
    private String rstr;

    @Basic
    @Column(name = "rstr_date", nullable = true)
    private Date rstrDate;

    @ManyToOne
    @JoinColumn(name="id_participant_info", nullable = false)
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "rstrList",fetch = FetchType.LAZY)
    private List<Rstr> listRstr;
}