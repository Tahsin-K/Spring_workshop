package lexicon.se.spring_workshop.impl;

import lexicon.se.spring_workshop.dao.AppUserDao;
import lexicon.se.spring_workshop.entity.AppUser;

import java.util.Collection;
import java.util.Optional;

public class AppUserDaoImpl implements AppUserDao {

    @Override
    public Optional<AppUser> findbyId(int Id) {
        return Optional.empty();
    }

    @Override
    public void delete(int Id) {

    }

    @Override
    public Object create(Object o) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public Collection findAll() {
        return null;
    }
}
