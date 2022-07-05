package com.example.demo.models;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ed_807", schema = "public", catalog = "db_cb_russia")
public class Ed807 {
    private long idEd807;
    private Integer edNo;
    private String xmlns;
    private Date edDate;
    private Integer edAuthor;
    private String creationReason;
    private Timestamp creationDateTime;
    private String infoTypeCode;
    private Date businessDay;
    private Integer directoryVersion;

    @Id
    @Column(name = "id_ed_807", nullable = false)
    public long getIdEd807() {
        return idEd807;
    }

    public void setIdEd807(long idEd807) {
        this.idEd807 = idEd807;
    }

    @Basic
    @Column(name = "ed_no", nullable = true)
    public Integer getEdNo() {
        return edNo;
    }

    public void setEdNo(Integer edNo) {
        this.edNo = edNo;
    }

    @Basic
    @Column(name = "xmlns", nullable = true, length = 20)
    public String getXmlns() {
        return xmlns;
    }

    public void setXmlns(String xmlns) {
        this.xmlns = xmlns;
    }

    @Basic
    @Column(name = "ed_date", nullable = true)
    public Date getEdDate() {
        return edDate;
    }

    public void setEdDate(Date edDate) {
        this.edDate = edDate;
    }

    @Basic
    @Column(name = "ed_author", nullable = true)
    public Integer getEdAuthor() {
        return edAuthor;
    }

    public void setEdAuthor(Integer edAuthor) {
        this.edAuthor = edAuthor;
    }

    @Basic
    @Column(name = "creation_reason", nullable = true, length = 4)
    public String getCreationReason() {
        return creationReason;
    }

    public void setCreationReason(String creationReason) {
        this.creationReason = creationReason;
    }

    @Basic
    @Column(name = "creation_date_time", nullable = true)
    public Timestamp getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Timestamp creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @Basic
    @Column(name = "info_type_code", nullable = true, length = 4)
    public String getInfoTypeCode() {
        return infoTypeCode;
    }

    public void setInfoTypeCode(String infoTypeCode) {
        this.infoTypeCode = infoTypeCode;
    }

    @Basic
    @Column(name = "business_day", nullable = true)
    public Date getBusinessDay() {
        return businessDay;
    }

    public void setBusinessDay(Date businessDay) {
        this.businessDay = businessDay;
    }

    @Basic
    @Column(name = "directory_version", nullable = true)
    public Integer getDirectoryVersion() {
        return directoryVersion;
    }

    public void setDirectoryVersion(Integer directoryVersion) {
        this.directoryVersion = directoryVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ed807 ed807 = (Ed807) o;
        return idEd807 == ed807.idEd807 && Objects.equals(edNo, ed807.edNo) && Objects.equals(xmlns, ed807.xmlns) && Objects.equals(edDate, ed807.edDate) && Objects.equals(edAuthor, ed807.edAuthor) && Objects.equals(creationReason, ed807.creationReason) && Objects.equals(creationDateTime, ed807.creationDateTime) && Objects.equals(infoTypeCode, ed807.infoTypeCode) && Objects.equals(businessDay, ed807.businessDay) && Objects.equals(directoryVersion, ed807.directoryVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEd807, edNo, xmlns, edDate, edAuthor, creationReason, creationDateTime, infoTypeCode, businessDay, directoryVersion);
    }
}
