package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.AppUser;
import lexicon.se.spring_workshop.entity.Author;

import java.util.Optional;

public interface AuthorDao extends BaseDao <Author>{

   Author findbyId (int Id);

    void delete (int Id);
}
