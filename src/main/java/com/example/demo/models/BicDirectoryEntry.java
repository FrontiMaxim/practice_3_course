package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "bic_directory_entry", schema = "public", catalog = "db_cb_russia")
public class BicDirectoryEntry {

    @Id
    @Column(name = "id_bic_directory_entry", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBicDirectoryEntry;

    @Basic
    @Column(name = "bic", nullable = true)
    private Long bic;

    @ManyToOne
    @JoinColumn(name = "id_ed_807", nullable = false)
    @JsonIgnore
    private Ed807 ed807;

    @OneToOne(mappedBy = "bicDirectoryEntry", fetch = FetchType.LAZY)
    private ParticipantInfo participantInfo;

    @OneToMany(mappedBy = "bicDirectoryEntry", fetch = FetchType.LAZY)
    private List<Swbic> listSwbic;

    @OneToMany(mappedBy = "bicDirectoryEntry", fetch = FetchType.LAZY)
    private List<Account> listAccount;
}
