package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "rstr_list", schema = "public", catalog = "db_cb_russia")
public class RstrList {
    private long idRstrList;
    private String rstr;
    private Date rstrDate;
    private Long idParticipantInfo;

    @Id
    @Column(name = "id_rstr_list", nullable = false)
    public long getIdRstrList() {
        return idRstrList;
    }

    public void setIdRstrList(long idRstrList) {
        this.idRstrList = idRstrList;
    }

    @Basic
    @Column(name = "rstr", nullable = true, length = 4)
    public String getRstr() {
        return rstr;
    }

    public void setRstr(String rstr) {
        this.rstr = rstr;
    }

    @Basic
    @Column(name = "rstr_date", nullable = true)
    public Date getRstrDate() {
        return rstrDate;
    }

    public void setRstrDate(Date rstrDate) {
        this.rstrDate = rstrDate;
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
        RstrList rstrList = (RstrList) o;
        return idRstrList == rstrList.idRstrList && Objects.equals(rstr, rstrList.rstr) && Objects.equals(rstrDate, rstrList.rstrDate) && Objects.equals(idParticipantInfo, rstrList.idParticipantInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRstrList, rstr, rstrDate, idParticipantInfo);
    }
}
