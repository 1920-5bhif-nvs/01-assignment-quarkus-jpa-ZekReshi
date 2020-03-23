package at.htl.coincollection.database;

import at.htl.coincollection.model.Coin;
import at.htl.coincollection.model.Collector;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class CollectorFacade extends Facade<Collector> {

    public List<Collector> getAll() {
        return em.createNamedQuery("Collector.getAll", Collector.class).getResultList();
    }

    public Collector getById(Long id) {
        EntityGraph eg = em.getEntityGraph("collector-entity-graph");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", eg);
        return em.find(Collector.class, id, properties);
    }

}
