package lexicon.se.spring_workshop.impl;


import lexicon.se.spring_workshop.Exception.DataDoesNotExistsException;
import lexicon.se.spring_workshop.dao.AuthorDao;
import lexicon.se.spring_workshop.entity.Author;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;



@Repository
public class AuthorDaoImpl implements AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Author findbyId(int Id) {
        return entityManager.find(Author.class, Id);
    }

    @Override
    public void delete(int Id) {
        Author author = entityManager.find(Author.class, Id);
        if (author != null) entityManager.remove(author);

    }

    @Override
    public Author create(Author author) {
        entityManager.persist(author);
        return (author);
    }

    @Override
    public Author update(Author author) {
        return entityManager.merge(author);
    }

    @Override
    public Collection<Author> findAll() {
        return entityManager.createQuery("select a from Author a", Author.class)
                .getResultList();
    }
}
