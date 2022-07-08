package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "xch_type", schema = "public", catalog = "db_cb_russia")
public class XchType {

    @Id
    @Column(name = "id_xch_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idXchType;

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
