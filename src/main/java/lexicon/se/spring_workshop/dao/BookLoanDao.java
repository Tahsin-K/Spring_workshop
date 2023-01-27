package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.AppUser;
import lexicon.se.spring_workshop.entity.BookLoan;

import java.util.Optional;

public interface BookLoanDao extends BaseDao {

    Optional<BookLoan> findbyId (int Id);

    void delete (int Id);
}
