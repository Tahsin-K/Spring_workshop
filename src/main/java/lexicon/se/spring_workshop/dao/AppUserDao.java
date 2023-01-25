package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.models.AppUser;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface AppUserDao {

    AppUser persists (AppUser appUser);
    Optional<AppUser> findbyId (int Id);
    Optional<AppUser> findAll();
    Optional<AppUser> create();
    AppUser update (AppUser appUser);
    void delete (int Id);


}
