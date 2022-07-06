package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Table(name = "participant_info", schema = "public", catalog = "db_cb_russia")
public class ParticipantInfo {

    @Id
    @Column(name = "id_participant_info", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idParticipantInfo;

    @Basic
    @Column(name = "name_p", nullable = true, length = 160)
    private String nameP;

    @Basic
    @Column(name = "cntr_cd", nullable = true, length = 2)
    private String cntrCd;

    @Basic
    @Column(name = "rgn", nullable = true, length = 2)
    private String rgn;

    @Basic
    @Column(name = "ind", nullable = true, length = 6)
    private String ind;

    @Basic
    @Column(name = "tnp", nullable = true, length = 5)
    private String tnp;

    @Basic
    @Column(name = "nnp", nullable = true, length = 25)
    private String nnp;

    @Basic
    @Column(name = "adr", nullable = true, length = 160)
    private String adr;

    @Basic
    @Column(name = "date_in", nullable = true)
    private Date dateIn;

    @Basic
    @Column(name = "pt_type", nullable = true, length = 2)
    private String ptType;

    @Basic
    @Column(name = "srvcs", nullable = true, length = 1)
    private String srvcs;

    @Basic
    @Column(name = "xch_type", nullable = true, length = 1)
    private String xchType;

    @Basic
    @Column(name = "uid", nullable = true)
    private Integer uid;

    @OneToOne
    @JoinColumn(name = "id_bic_directory_entry", nullable = false)
    private BicDirectoryEntry bicDirectoryEntry;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<ParticipantStatus> listParticipantsStatus;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<Srvcs> listSrvcs;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<XchType> listXchType;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<RstrList> listRstrList;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<PtType> listPtType;
}