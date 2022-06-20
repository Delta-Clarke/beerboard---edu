package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.Region;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RegionRepository extends CrudRepository<Region, String> {

    //répartition des brasserie par région
    @Query("select r.nomRegion from Region r group by r.nomRegion order by r.nomRegion asc")
    public ArrayList<String> getNomRegionAsc();

    @Query("select count(b.nomBrasserie) from Brasserie b group by b.region.nomRegion order by b.region.nomRegion asc")
    public ArrayList<String> getNbRegion();
}
