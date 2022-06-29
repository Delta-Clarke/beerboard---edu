package fr.almeri.beerboard.repositories;


import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.BiereId;
import fr.almeri.beerboard.models.Brasserie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface BiereRepository extends CrudRepository<Biere, BiereId> {

    //Nombre de bières par taux alcool
    @Query("select count (b.tauxAlcool) from Biere b group by b.tauxAlcool order by b.tauxAlcool asc")
    public ArrayList<Double> getTauxAlcoolGroup();

    @Query("select b.marque.nomMarque from Biere b group by b.marque.nomMarque order by b.marque.nomMarque asc")
    public List<String> getNomBiere();

    @Query("select b.tauxAlcool from Biere b group by b.tauxAlcool order by b.tauxAlcool asc")
    public ArrayList<String> getTauxAlcool();

    //Nombre de versions par marque
    @Query("select count(b.version) from Biere b group by b.marque.nomMarque order by b.marque.nomMarque asc")
    public ArrayList<Integer> getNbVersion();


    @Query("select b from Biere b where b.marque.brasserie.codeBrasserie = :code order by b.marque.nomMarque, b.version asc")
    public ArrayList<Biere> getMarqueVersionByCodeBrasserie(String code);
}
