package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.AppUser;

import java.util.Optional;

public interface AppUserDao extends BaseDao {


    Optional<AppUser> findbyId (int Id);

    void delete (int Id);


}
