package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Table(name = "ed_807", schema = "public", catalog = "db_cb_russia")
public class Ed807 {

    @Id
    @Column(name = "id_ed_807", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEd807;

    @Basic
    @Column(name = "ed_no", nullable = true)
    private Long edNo;

    @Basic
    @Column(name = "xmlns", nullable = true, length = 20)
    private String xmlns;

    @Basic
    @Column(name = "ed_date", nullable = true)
    private Date edDate;

    @Basic
    @Column(name = "ed_author", nullable = true)
    private Long edAuthor;

    @Basic
    @Column(name = "creation_reason", nullable = true, length = 10)
    private String creationReason;

    @Basic
    @Column(name = "creation_date_time", nullable = true)
    private Date creationDateTime;

    @Basic
    @Column(name = "info_type_code", nullable = true, length = 10)
    private String infoTypeCode;

    @Basic
    @Column(name = "business_day", nullable = true)
    private Date businessDay;

    @Basic
    @Column(name = "directory_version", nullable = true)
    private Long directoryVersion;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ed807")
//    private List<CreationReason> listCreationReason;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "ed807")
//    private List<InfoTypeCode> listInfoTypeCode;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ed807")
    private List<BicDirectoryEntry> listBicDirectoryEntry;

    @OneToOne
    @JoinColumn(name = "id_file", nullable = false)
    @JsonIgnore
    private File file;
}
