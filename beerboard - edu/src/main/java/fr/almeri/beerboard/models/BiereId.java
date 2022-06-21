package fr.almeri.beerboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//Class mock
//Qui correspond à ma clef primaire
//donc 2 attributs : marque & version
public class BiereId implements Serializable {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nom_marque")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Marque marque;

    @Id
    @Column(name = "version")
    private String version;

    public BiereId() {
    }

    public BiereId(String nomMarque, String version){
        this.marque=new Marque(nomMarque);
        this.version=version;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque pMarque) {
        this.marque = pMarque;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String pVersion) {
        this.version = pVersion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BiereId biereId = (BiereId) o;
        return Objects.equals(marque, biereId.marque) && Objects.equals(version, biereId.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marque, version);
    }
}