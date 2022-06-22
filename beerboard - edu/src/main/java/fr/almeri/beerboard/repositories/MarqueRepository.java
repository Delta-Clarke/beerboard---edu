package fr.almeri.beerboard.repositories;


import fr.almeri.beerboard.models.Biere;
import fr.almeri.beerboard.models.Marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MarqueRepository extends CrudRepository<Marque, String> {

//    @Query("select m from Marque m where m.nomMarque = :code order by b.marque.nomMarque, b.version asc")
//    public ArrayList<Biere> getMarqueVersionByCodeBrasserie(String code);
}
