package fr.almeri.beerboard.models;

import java.util.Objects;

public class Region {

    //ATTRIBUTS
    private String nomRegion;
    private  String nomPays;

    //CONSTRUCTEUR
    public Region() {}

    //GETTERS & SETTERS
    public String getNomRegion() {
        return nomRegion;
    }

    public void setNomRegion(String pNomRegion) {
        this.nomRegion = pNomRegion;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String pNomPays) {
        this.nomPays = pNomPays;
    }

    @Override
    public String toString() {
        return "Region{" +
                "nomRegion='" + nomRegion + '\'' +
                ", nomPays='" + nomPays + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(nomRegion, region.nomRegion) && Objects.equals(nomPays, region.nomPays);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomRegion, nomPays);
    }
}
