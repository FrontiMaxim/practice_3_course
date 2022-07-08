package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Srvcs {

    @Id
    @Column(name = "id_srvcs", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSrvcs;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;


//    @ManyToOne
//    @JoinColumn(name="id_participant_info", nullable = false)
//    private ParticipantInfo participantInfo;
}
