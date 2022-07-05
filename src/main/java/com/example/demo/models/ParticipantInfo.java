package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "participant_info", schema = "public", catalog = "db_cb_russia")
public class ParticipantInfo {
    private long idParticipantInfo;
    private String nameP;
    private String cntrCd;
    private String rgn;
    private String ind;
    private String tnp;
    private String nnp;
    private String adr;
    private Date dateIn;
    private String ptType;
    private String srvcs;
    private String xchType;
    private Integer uid;
    private String participantsStatus;
    private Long idBicDirectoryEntry;

    @Id
    @Column(name = "id_participant_info", nullable = false)
    public long getIdParticipantInfo() {
        return idParticipantInfo;
    }

    public void setIdParticipantInfo(long idParticipantInfo) {
        this.idParticipantInfo = idParticipantInfo;
    }

    @Basic
    @Column(name = "name_p", nullable = true, length = 160)
    public String getNameP() {
        return nameP;
    }

    public void setNameP(String nameP) {
        this.nameP = nameP;
    }

    @Basic
    @Column(name = "cntr_cd", nullable = true, length = 2)
    public String getCntrCd() {
        return cntrCd;
    }

    public void setCntrCd(String cntrCd) {
        this.cntrCd = cntrCd;
    }

    @Basic
    @Column(name = "rgn", nullable = true, length = 2)
    public String getRgn() {
        return rgn;
    }

    public void setRgn(String rgn) {
        this.rgn = rgn;
    }

    @Basic
    @Column(name = "ind", nullable = true, length = 6)
    public String getInd() {
        return ind;
    }

    public void setInd(String ind) {
        this.ind = ind;
    }

    @Basic
    @Column(name = "tnp", nullable = true, length = 5)
    public String getTnp() {
        return tnp;
    }

    public void setTnp(String tnp) {
        this.tnp = tnp;
    }

    @Basic
    @Column(name = "nnp", nullable = true, length = 25)
    public String getNnp() {
        return nnp;
    }

    public void setNnp(String nnp) {
        this.nnp = nnp;
    }

    @Basic
    @Column(name = "adr", nullable = true, length = 160)
    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    @Basic
    @Column(name = "date_in", nullable = true)
    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(Date dateIn) {
        this.dateIn = dateIn;
    }

    @Basic
    @Column(name = "pt_type", nullable = true, length = 2)
    public String getPtType() {
        return ptType;
    }

    public void setPtType(String ptType) {
        this.ptType = ptType;
    }

    @Basic
    @Column(name = "srvcs", nullable = true, length = 1)
    public String getSrvcs() {
        return srvcs;
    }

    public void setSrvcs(String srvcs) {
        this.srvcs = srvcs;
    }

    @Basic
    @Column(name = "xch_type", nullable = true, length = 1)
    public String getXchType() {
        return xchType;
    }

    public void setXchType(String xchType) {
        this.xchType = xchType;
    }

    @Basic
    @Column(name = "uid", nullable = true)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "participants_status", nullable = true, length = 4)
    public String getParticipantsStatus() {
        return participantsStatus;
    }

    public void setParticipantsStatus(String participantsStatus) {
        this.participantsStatus = participantsStatus;
    }

    @Basic
    @Column(name = "id_bic_directory_entry", nullable = true)
    public Long getIdBicDirectoryEntry() {
        return idBicDirectoryEntry;
    }

    public void setIdBicDirectoryEntry(Long idBicDirectoryEntry) {
        this.idBicDirectoryEntry = idBicDirectoryEntry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipantInfo that = (ParticipantInfo) o;
        return idParticipantInfo == that.idParticipantInfo && Objects.equals(nameP, that.nameP) && Objects.equals(cntrCd, that.cntrCd) && Objects.equals(rgn, that.rgn) && Objects.equals(ind, that.ind) && Objects.equals(tnp, that.tnp) && Objects.equals(nnp, that.nnp) && Objects.equals(adr, that.adr) && Objects.equals(dateIn, that.dateIn) && Objects.equals(ptType, that.ptType) && Objects.equals(srvcs, that.srvcs) && Objects.equals(xchType, that.xchType) && Objects.equals(uid, that.uid) && Objects.equals(participantsStatus, that.participantsStatus) && Objects.equals(idBicDirectoryEntry, that.idBicDirectoryEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idParticipantInfo, nameP, cntrCd, rgn, ind, tnp, nnp, adr, dateIn, ptType, srvcs, xchType, uid, participantsStatus, idBicDirectoryEntry);
    }
}
