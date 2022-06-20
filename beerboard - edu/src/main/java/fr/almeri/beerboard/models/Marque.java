package fr.almeri.beerboard.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "marque")

public class Marque {

    //ATTRIBUTS
    @Id
    @Column(name = "nom_marque")
    private String nomMarque;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "code_brasserie")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private  Brasserie brasserie;

    //CONSTRUCTEUR
    public Marque() {}

    //GETTERS & SETTERS
    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String pNomMarque) {
        this.nomMarque = pNomMarque;
    }

    public Brasserie getBrasserie() {
        return brasserie;
    }

    public void setBrasserie(Brasserie pBrasserie) {
        this.brasserie = pBrasserie;
    }

    @Override
    public String toString() {return nomMarque;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marque marque = (Marque) o;
        return Objects.equals(nomMarque, marque.nomMarque) && Objects.equals(brasserie, marque.brasserie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomMarque, brasserie);
    }
}
