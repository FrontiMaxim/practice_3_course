package com.example.demo.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Swbic {
    private long idSwbic;
    private String swbic;
    private Integer defaultSwbic;
    private Long idBicDirectoryEntry;

    @Id
    @Column(name = "id_swbic", nullable = false)
    public long getIdSwbic() {
        return idSwbic;
    }

    public void setIdSwbic(long idSwbic) {
        this.idSwbic = idSwbic;
    }

    @Basic
    @Column(name = "swbic", nullable = true, length = 11)
    public String getSwbic() {
        return swbic;
    }

    public void setSwbic(String swbic) {
        this.swbic = swbic;
    }

    @Basic
    @Column(name = "default_swbic", nullable = true)
    public Integer getDefaultSwbic() {
        return defaultSwbic;
    }

    public void setDefaultSwbic(Integer defaultSwbic) {
        this.defaultSwbic = defaultSwbic;
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
        Swbic swbic1 = (Swbic) o;
        return idSwbic == swbic1.idSwbic && Objects.equals(swbic, swbic1.swbic) && Objects.equals(defaultSwbic, swbic1.defaultSwbic) && Objects.equals(idBicDirectoryEntry, swbic1.idBicDirectoryEntry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSwbic, swbic, defaultSwbic, idBicDirectoryEntry);
    }
}
