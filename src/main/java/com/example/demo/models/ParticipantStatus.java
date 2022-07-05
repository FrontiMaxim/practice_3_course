package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "participant_status", schema = "public", catalog = "db_cb_russia")
public class ParticipantStatus {
    private int idParticipantStatus;
    private String code;
    private String name;
    private Long idParticipantInfo;

    @Id
    @Column(name = "id_participant_status", nullable = false)
    public int getIdParticipantStatus() {
        return idParticipantStatus;
    }

    public void setIdParticipantStatus(int idParticipantStatus) {
        this.idParticipantStatus = idParticipantStatus;
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
        ParticipantStatus that = (ParticipantStatus) o;
        return idParticipantStatus == that.idParticipantStatus && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(idParticipantInfo, that.idParticipantInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipantStatus, code, name, idParticipantInfo);
    }
}
