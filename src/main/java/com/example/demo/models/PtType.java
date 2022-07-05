package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pt_type", schema = "public", catalog = "db_cb_russia")
public class PtType {
    private long idPtType;
    private String code;
    private String name;
    private Long idParticipantInfo;

    @Id
    @Column(name = "id_pt_type", nullable = false)
    public long getIdPtType() {
        return idPtType;
    }

    public void setIdPtType(long idPtType) {
        this.idPtType = idPtType;
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
    @Column(name = "id_participant_info", nullable = true)
    public Long getIdParticipantInfo() {
        return idParticipantInfo;
    }

    public void setIdParticipantInfo(Long idParticipantInfo) {
        this.idParticipantInfo = idParticipantInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PtType ptType = (PtType) o;
        return idPtType == ptType.idPtType && Objects.equals(code, ptType.code) && Objects.equals(name, ptType.name) && Objects.equals(idParticipantInfo, ptType.idParticipantInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPtType, code, name, idParticipantInfo);
    }
}
