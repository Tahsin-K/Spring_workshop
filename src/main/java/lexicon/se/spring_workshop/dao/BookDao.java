package lexicon.se.spring_workshop.dao;

import lexicon.se.spring_workshop.entity.AppUser;
import lexicon.se.spring_workshop.entity.Book;

import java.util.Optional;

public interface BookDao extends BaseDao<Book> {

    Book findbyId (int Id);

    void delete (int Id);
}
