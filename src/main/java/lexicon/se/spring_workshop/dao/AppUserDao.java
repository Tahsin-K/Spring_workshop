package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.AppUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface AppUserDao extends BaseDao<AppUser> {


    AppUser findbyId (int Id);

    void delete (int Id);



}
