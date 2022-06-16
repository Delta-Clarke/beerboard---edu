package fr.almeri.beerboard.models;

import java.util.Objects;

public class Brasserie {

    //ATTRIBUTS
    private String codeBrasserie;
    private  String nomBrasserie;
    private String ville;
    private Region region;
    private String commentaire;

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

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String pCommentaire) {
        this.commentaire = pCommentaire;
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
        return Objects.equals(codeBrasserie, brasserie.codeBrasserie) && Objects.equals(nomBrasserie, brasserie.nomBrasserie) && Objects.equals(ville, brasserie.ville) && Objects.equals(region, brasserie.region) && Objects.equals(commentaire, brasserie.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeBrasserie, nomBrasserie, ville, region, commentaire);
    }
}
