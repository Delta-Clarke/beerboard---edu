package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.Pays;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository indique que c'est dans cette interface qu'on effectue les requête en bdd
//extend CrudRepository<NomDeLaClasse, TypeID>
@Repository
public interface PaysRepository extends CrudRepository<Pays, String> {
}
