package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Swbic {
    @Id
    @Column(name = "id_swbic", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idSwbic;

    @Basic
    @Column(name = "swbic", nullable = true, length = 20)
    private String swbic;

    @Basic
    @Column(name = "default_swbic", nullable = true)
    private Long defaultSwbic;

    @ManyToOne
    @JoinColumn(name="id_bic_directory_entry", nullable = false)
    @JsonIgnore
    private BicDirectoryEntry bicDirectoryEntry;
}
