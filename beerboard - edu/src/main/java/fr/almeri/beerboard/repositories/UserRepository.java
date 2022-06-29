package fr.almeri.beerboard.repositories;

import fr.almeri.beerboard.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, String> {

    @Query("select u from User u where u.login = :login and u.password = :password")
    public User getUser(String login, String password);

}
