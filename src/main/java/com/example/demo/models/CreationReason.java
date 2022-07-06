package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "creation_reason", schema = "public", catalog = "db_cb_russia")
public class CreationReason {

    @Id
    @Column(name = "id_creation_reason", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCreationReason;

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    private String code;

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_ed_807", nullable = false)
    private Ed807 ed807;
}
