package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.Pays;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

//@Repository indique que c'est dans cette interface qu'on effectue les requête en bdd
//extend CrudRepository<NomDeLaClasse, TypeID>
@Repository
public interface PaysRepository extends CrudRepository<Pays, String> {

    //SELECT nom_pays FROM pays ORDER BY nom_pays asc;
    @Query("select p.nomPays from Pays p order by p.nomPays asc")
    public ArrayList<String> getNomPaysAsc();

    @Query("select p.consomation from Pays p order by p.nomPays asc")
    public ArrayList<Double> getConsoPays();

    @Query("select p.production from Pays p order by p.nomPays asc")
    public ArrayList<Double> getProdPays();


}
