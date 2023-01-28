package lexicon.se.spring_workshop.impl;

import lexicon.se.spring_workshop.dao.DetailsDao;
import lexicon.se.spring_workshop.entity.Details;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;


@Repository
public class DetailsDaoImpl implements DetailsDao {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    public Details create(Details details) {
        entityManager.persist(details);
        return (details);
    }

    @Override
    public Details update(Details details) {
        return entityManager.merge(details);
    }

    @Override
    public Collection<Details> findAll() {
        return entityManager.createQuery("select d from Details d", Details.class)
                .getResultList();
    }

    @Override
    public Details findbyId(int Id) {
        return entityManager.find(Details.class, Id);
    }

    @Override
    public void delete(int Id) {
        Details details = entityManager.find(Details.class, Id);
            if (details != null) entityManager.remove(details);

    }
}