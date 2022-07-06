package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "pt_type", schema = "public", catalog = "db_cb_russia")
public class PtType {

    @Id
    @Column(name = "id_pt_type", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPtType;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_participant_info", nullable = false)
    private ParticipantInfo participantInfo;
}
