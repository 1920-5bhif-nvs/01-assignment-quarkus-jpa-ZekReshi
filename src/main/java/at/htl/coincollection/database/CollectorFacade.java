package at.htl.coincollection.database;

import at.htl.coincollection.model.Collector;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CollectorFacade extends Facade<Collector> {

    public List<Collector> getAll() {
        return em.createNamedQuery("Collector.getAll", Collector.class).getResultList();
    }

    public Collector getById(Long id) {
        return em.find(Collector.class, id);
    }

}
