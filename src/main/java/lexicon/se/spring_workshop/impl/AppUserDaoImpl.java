package lexicon.se.spring_workshop.impl;

import lexicon.se.spring_workshop.dao.AppUserDao;
import lexicon.se.spring_workshop.entity.AppUser;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;


@Repository
public class AppUserDaoImpl implements AppUserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public AppUser findbyId(int Id) {
        return entityManager.find(AppUser.class, Id);

    }

    @Override
    @Transactional
    public void delete(int Id) {
        AppUser appuser = entityManager.find(AppUser.class, Id);
        if (appuser != null) entityManager.remove(appuser);

    }

    @Override
    @Transactional
    public AppUser create(AppUser appUser) {
       entityManager.persist(appUser);
        return appUser;
    }

    @Override
    @Transactional
    public AppUser update(AppUser appUser) {
        return entityManager.merge(appUser);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<AppUser> findAll() {
        return entityManager.createQuery("select app from AppUser app", AppUser.class )
                .getResultList();
    }
}

