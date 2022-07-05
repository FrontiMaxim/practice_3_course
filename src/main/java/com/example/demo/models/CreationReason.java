package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "creation_reason", schema = "public", catalog = "db_cb_russia")
public class CreationReason {
    private long idCreationReason;
    private String code;
    private String name;
    private Long idEd807;

    @Id
    @Column(name = "id_creation_reason", nullable = false)
    public long getIdCreationReason() {
        return idCreationReason;
    }

    public void setIdCreationReason(long idCreationReason) {
        this.idCreationReason = idCreationReason;
    }

    @Basic
    @Column(name = "code", nullable = true, length = 6)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 300)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "id_ed_807", nullable = true)
    public Long getIdEd807() {
        return idEd807;
    }

    public void setIdEd807(Long idEd807) {
        this.idEd807 = idEd807;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreationReason that = (CreationReason) o;
        return idCreationReason == that.idCreationReason && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(idEd807, that.idEd807);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCreationReason, code, name, idEd807);
    }
}
