package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "file", schema = "public", catalog = "db_cb_russia")
@SequenceGenerator(name = "ID_GEN", sequenceName = "file_id_file_seq", allocationSize = 1)
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN")
    @Column(name = "id_file", nullable = false)
    private Long idFile;

    @Basic
    @Column(name = "name_file", nullable = false, length = 20)
    private String nameFile;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "file")
    private Ed807 ed807;
}
