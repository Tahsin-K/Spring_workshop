package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.Details;

import java.util.Optional;

public interface DetailsDao extends BaseDao<Details> {


    Details findbyId (int Id);

    void delete (int Id);

}
