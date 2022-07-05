package com.example.demo.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Srvcs {
    private long idSrvcs;
    private String code;
    private String name;
    private Integer idParticipantInfo;

    @Id
    @Column(name = "id_srvcs", nullable = false)
    public long getIdSrvcs() {
        return idSrvcs;
    }

    public void setIdSrvcs(long idSrvcs) {
        this.idSrvcs = idSrvcs;
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
    public Integer getIdParticipantInfo() {
        return idParticipantInfo;
    }

    public void setIdParticipantInfo(Integer idParticipantInfo) {
        this.idParticipantInfo = idParticipantInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Srvcs srvcs = (Srvcs) o;
        return idSrvcs == srvcs.idSrvcs && Objects.equals(code, srvcs.code) && Objects.equals(name, srvcs.name) && Objects.equals(idParticipantInfo, srvcs.idParticipantInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSrvcs, code, name, idParticipantInfo);
    }
}
