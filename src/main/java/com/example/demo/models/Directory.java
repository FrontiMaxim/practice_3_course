package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "directory", schema = "public", catalog = "db_cb_russia")
public class Directory {
    @Id
    @Column(name = "id_directory", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDirectory;

    @Basic
    @Column(name = "engish_term", nullable = true, length = 40)
    private String englishTerm;

    @Basic
    @Column(name = "russian_term", nullable = true, length = 40)
    private String russianTerm;
}
