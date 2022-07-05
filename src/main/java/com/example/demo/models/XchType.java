package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "xch_type", schema = "public", catalog = "db_cb_russia")
public class XchType {
    private long idXchType;
    private String code;
    private String name;
    private Long idParticipantInfo;

    @Id
    @Column(name = "id_xch_type", nullable = false)
    public long getIdXchType() {
        return idXchType;
    }

    public void setIdXchType(long idXchType) {
        this.idXchType = idXchType;
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
        XchType xchType = (XchType) o;
        return idXchType == xchType.idXchType && Objects.equals(code, xchType.code) && Objects.equals(name, xchType.name) && Objects.equals(idParticipantInfo, xchType.idParticipantInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idXchType, code, name, idParticipantInfo);
    }
}
