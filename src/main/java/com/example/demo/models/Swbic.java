package com.example.demo.models;

import javax.persistence.*;

@Entity
public class Swbic {
    @Id
    @Column(name = "id_swbic", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSwbic;

    @Basic
    @Column(name = "swbic", nullable = true, length = 11)
    private String swbic;

    @Basic
    @Column(name = "default_swbic", nullable = true)
    private Long defaultSwbic;

    @ManyToOne
    @JoinColumn(name="id_bic_directory_entry", nullable = false)
    private BicDirectoryEntry bicDirectoryEntry;
}
