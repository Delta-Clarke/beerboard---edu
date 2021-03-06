package fr.almeri.beerboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="brasserie")

public class Brasserie {

    //ATTRIBUTS

    @Id
    @Column(name = "code_brasserie")
    private String codeBrasserie;

    @Column(name = "nom_brasserie")
    private  String nomBrasserie;

    @Column(name = "ville")
    private String ville;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Region region;

    //CONSTRUCTEUR
    public Brasserie() {}

    //GETTERS & SETTERS
    public String getCodeBrasserie() {
        return codeBrasserie;
    }

    public void setCodeBrasserie(String pCodeBrasserie) {
        this.codeBrasserie = pCodeBrasserie;
    }

    public String getNomBrasserie() {
        return nomBrasserie;
    }

    public void setNomBrasserie(String pNomBrasserie) {
        this.nomBrasserie = pNomBrasserie;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String pVille) {
        this.ville = pVille;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region pRegion) {
        this.region = pRegion;
    }


    @Override
    public String toString() {
        return "Brasserie{" +
                "nomBrasserie='" + nomBrasserie + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brasserie brasserie = (Brasserie) o;
        return Objects.equals(codeBrasserie, brasserie.codeBrasserie) && Objects.equals(nomBrasserie, brasserie.nomBrasserie) && Objects.equals(ville, brasserie.ville) && Objects.equals(region, brasserie.region);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBrasserie, nomBrasserie, ville, region);
    }
}
