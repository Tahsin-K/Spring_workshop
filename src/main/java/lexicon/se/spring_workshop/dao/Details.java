package lexicon.se.spring_workshop.dao;

import java.util.Optional;

public interface Details extends BaseDao {


    Optional<Details> findbyId (int Id);

    void delete (int Id);

}
