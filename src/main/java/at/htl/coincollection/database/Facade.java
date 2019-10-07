package at.htl.coincollection.database;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

abstract class Facade<T> {

    @Inject
    EntityManager em;

    public void insert(T t) {
        em.persist(t);
    }

    public abstract List<T> getAll();

    public abstract T getById(Long id);

}
