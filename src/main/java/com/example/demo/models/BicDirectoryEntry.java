package com.example.demo.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bic_directory_entry", schema = "public", catalog = "db_cb_russia")
public class BicDirectoryEntry {
    private long idBicDirectoryEntry;
    private Integer bic;
    private Long idEd807;

    @Id
    @Column(name = "id_bic_directory_entry", nullable = false)
    public long getIdBicDirectoryEntry() {
        return idBicDirectoryEntry;
    }

    public void setIdBicDirectoryEntry(long idBicDirectoryEntry) {
        this.idBicDirectoryEntry = idBicDirectoryEntry;
    }

    @Basic
    @Column(name = "bic", nullable = true)
    public Integer getBic() {
        return bic;
    }

    public void setBic(Integer bic) {
        this.bic = bic;
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
        BicDirectoryEntry that = (BicDirectoryEntry) o;
        return idBicDirectoryEntry == that.idBicDirectoryEntry && Objects.equals(bic, that.bic) && Objects.equals(idEd807, that.idEd807);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBicDirectoryEntry, bic, idEd807);
    }
}
