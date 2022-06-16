package fr.almeri.beerboard.models;

import java.util.Objects;

public class Pays {

    //ATTRIBUTS
    private String nomPays;
    private  Double consomation;
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
