package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.Brasserie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface BrasserieRepository extends CrudRepository <Brasserie, String> {


    //Nombre de marque référencé par brasserie
    @Query("select b.nomBrasserie from Brasserie b group by b.nomBrasserie order by b.nomBrasserie asc")
    public ArrayList<String> getNomBrasserieAsc();

    @Query("select count(m.nomMarque) from Marque m group by m.brasserie.nomBrasserie order by m.brasserie.nomBrasserie asc")
    public ArrayList<String> getNbMarque();
}
