package lexicon.se.spring_workshop.dao;

import java.util.Collection;
import java.util.Collections;

public interface BaseDao<T> {

    T create (T t);
    T update (T t);
    Collection<T> findAll();


}
