package fr.almeri.beerboard.models;

import java.util.Objects;

public class Type {

    //ATTRIBUTS
    private Integer noType;
    private  String nomType;
    private String description;
    private String fermentation;
    private String commentaire;

    //CONSTRUCTEUR


    public Type() {}

    //GETTERS & SETTERS
    public Integer getNoType() {
        return noType;
    }

    public void setNoType(Integer pNoType) {
        this.noType = pNoType;
    }

    public String getNomType() {
        return nomType;
    }

    public void setNomType(String pNomType) {
        this.nomType = pNomType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String pDescription) {
        this.description = pDescription;
    }

    public String getFermentation() {
        return fermentation;
    }

    public void setFermentation(String pFermentation) {
        this.fermentation = pFermentation;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String pCommentaire) {
        this.commentaire = pCommentaire;
    }

    @Override
    public String toString() {
        return "Type{" +
                "nomType='" + nomType + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(noType, type.noType) && Objects.equals(nomType, type.nomType) && Objects.equals(description, type.description) && Objects.equals(fermentation, type.fermentation) && Objects.equals(commentaire, type.commentaire);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noType, nomType, description, fermentation, commentaire);
    }
}
