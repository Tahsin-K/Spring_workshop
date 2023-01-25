package lexicon.se.spring_workshop.dao;

import java.util.Optional;

public interface Details {

    Details persists (Details details);
    Optional<Details> findbyId (int Id);
    Optional <Details> findAll ();
    Details update (Details details);
    void delete (int Id);

}
