package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "info_type_code", schema = "public", catalog = "db_cb_russia")
public class InfoTypeCode {

    @Id
    @Column(name = "id_info_type_code", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idInfoTypeCode;

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
