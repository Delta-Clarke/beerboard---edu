package fr.almeri.beerboard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

//@Entity & @Table: j'indique la table qui correspond à l'objet Pays
@Entity
@Table(name="pays")

public class Pays {

    //ATTRIBUTS
    //@Id j'indique que l'attribut ci-après est une clef primaire
    @Id
    @Column(name="nom_pays")
    private String nomPays;
    @Column(name="consommation")
    private  Double consomation;
    @Column(name="production")
    private Double production;

    //CONSTRUCTEUR
    public Pays() {}

    //GETTERS & SETTERS
    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String pNomPays) {
        this.nomPays = pNomPays;
    }

    public Double getConsomation() {
        return consomation;
    }

    public void setConsomation(Double pConsomation) {
        this.consomation = pConsomation;
    }

    public Double getProduction() {
        return production;
    }

    public void setProduction(Double pProduction) {
        this.production = pProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pays pays = (Pays) o;
        return Objects.equals(nomPays, pays.nomPays) && Objects.equals(consomation, pays.consomation) && Objects.equals(production, pays.production);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomPays, consomation, production);
    }
}
