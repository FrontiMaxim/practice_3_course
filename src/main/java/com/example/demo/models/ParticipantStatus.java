package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "participant_status", schema = "public", catalog = "db_cb_russia")
public class ParticipantStatus {
    @Id
    @Column(name = "id_participant_status", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParticipantStatus;

    @Basic
    @Column(name = "code", nullable = true, length = 10)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

//    @ManyToOne
//    @JoinColumn(name="id_participant_info", nullable = false)
//    private ParticipantInfo participantInfo;
}
