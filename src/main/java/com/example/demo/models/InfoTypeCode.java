package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "info_type_code", schema = "public", catalog = "db_cb_russia")
public class InfoTypeCode {
    private long idInfoTypeCode;
    private String code;
    private String name;
    private Long idEd807;

    @Id
    @Column(name = "id_info_type_code", nullable = false)
    public long getIdInfoTypeCode() {
        return idInfoTypeCode;
    }

    public void setIdInfoTypeCode(long idInfoTypeCode) {
        this.idInfoTypeCode = idInfoTypeCode;
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
        InfoTypeCode that = (InfoTypeCode) o;
        return idInfoTypeCode == that.idInfoTypeCode && Objects.equals(code, that.code) && Objects.equals(name, that.name) && Objects.equals(idEd807, that.idEd807);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInfoTypeCode, code, name, idEd807);
    }
}
