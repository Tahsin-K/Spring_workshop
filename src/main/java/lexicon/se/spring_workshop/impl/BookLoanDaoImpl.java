package lexicon.se.spring_workshop.impl;

import lexicon.se.spring_workshop.dao.BookLoanDao;
import lexicon.se.spring_workshop.entity.BookLoan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class BookLoanDaoImpl implements BookLoanDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public BookLoan create(BookLoan bookLoan) {
        entityManager.persist(bookLoan);
        return (bookLoan);
    }

    @Override
    public BookLoan update(BookLoan bookLoan) {
        return entityManager.merge(bookLoan);
    }

    @Override
    public Collection<BookLoan> findAll() {
        return entityManager.createQuery("select bl from BookLoan bl", BookLoan.class)
                .getResultList();
    }

    @Override
    public BookLoan findbyId(int Id) {
        return entityManager.find(BookLoan.class, Id);
    }

    @Override
    public void delete(int Id) {
        BookLoan bookLoan = entityManager.find(BookLoan.class,Id);
        if(bookLoan != null) entityManager.remove(bookLoan);

    }
}
