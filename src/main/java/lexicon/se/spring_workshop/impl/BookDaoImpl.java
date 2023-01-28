package lexicon.se.spring_workshop.impl;

import lexicon.se.spring_workshop.dao.BookDao;
import lexicon.se.spring_workshop.entity.Book;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;


@Repository
public class BookDaoImpl implements BookDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public Book create(Book book) {
        entityManager.persist(book);
        return (book);
    }

    @Override
    @Transactional
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    @Transactional
    public Collection<Book> findAll() {
       return entityManager.createQuery("select b from Book b", Book.class)
                .getResultList();
    }

    @Override
    public Book findbyId(int Id) {
       return  entityManager.find(Book.class, Id);
    }

    @Override
    @Transactional
    public void delete(int Id) {
       Book book= entityManager.find(Book.class, Id);
        if(book != null) entityManager.remove(book);

    }
}
