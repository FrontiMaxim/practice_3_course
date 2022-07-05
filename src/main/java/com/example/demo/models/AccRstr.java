package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "acc_rstr", schema = "public", catalog = "db_cb_russia")
public class AccRstr {
    private long idAccRstr;
    private String code;
    private String name;
    private Long idAccRstrList;

    @Id
    @Column(name = "id_acc_rstr", nullable = false)
    public long getIdAccRstr() {
        return idAccRstr;
    }

    public void setIdAccRstr(long idAccRstr) {
        this.idAccRstr = idAccRstr;
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
    @Column(name = "id_acc_rstr_list", nullable = true)
    public Long getIdAccRstrList() {
        return idAccRstrList;
    }

    public void setIdAccRstrList(Long idAccRstrList) {
        this.idAccRstrList = idAccRstrList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccRstr accRstr = (AccRstr) o;
        return idAccRstr == accRstr.idAccRstr && Objects.equals(code, accRstr.code) && Objects.equals(name, accRstr.name) && Objects.equals(idAccRstrList, accRstr.idAccRstrList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAccRstr, code, name, idAccRstrList);
    }
}
