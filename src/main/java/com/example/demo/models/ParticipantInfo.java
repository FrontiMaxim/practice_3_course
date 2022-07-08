package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long idParticipantInfo;

    @Basic
    @Column(name = "name_p", nullable = true, length = 400)
    private String nameP;

    @Basic
    @Column(name = "cntr_cd", nullable = true, length = 20)
    private String cntrCd;

    @Basic
    @Column(name = "rgn", nullable = true, length = 20)
    private String rgn;

    @Basic
    @Column(name = "ind", nullable = true, length = 20)
    private String ind;

    @Basic
    @Column(name = "tnp", nullable = true, length = 20)
    private String tnp;

    @Basic
    @Column(name = "nnp", nullable = true, length = 100)
    private String nnp;

    @Basic
    @Column(name = "adr", nullable = true, length = 400)
    private String adr;

    @Basic
    @Column(name = "date_in", nullable = true)
    private Date dateIn;

    @Basic
    @Column(name = "pt_type", nullable = true, length = 20)
    private String ptType;

    @Basic
    @Column(name = "srvcs", nullable = true, length = 20)
    private String srvcs;

    @Basic
    @Column(name = "xch_type", nullable = true, length = 20)
    private String xchType;

    @Basic
    @Column(name = "uid", nullable = true)
    private Long uid;

    @OneToOne
    @JoinColumn(name = "id_bic_directory_entry", nullable = false)
    @JsonIgnore
    private BicDirectoryEntry bicDirectoryEntry;

//    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
//    private List<ParticipantStatus> listParticipantsStatus;

//    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
//    private List<Srvcs> listSrvcs;

//    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
//    private List<XchType> listXchType;

    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
    private List<RstrList> listRstrList;

//    @OneToMany(mappedBy = "participantInfo", fetch = FetchType.LAZY)
//    private List<PtType> listPtType;
}
