package at.htl.coincollection.database;

import at.htl.coincollection.model.Coin;
import at.htl.coincollection.model.Source;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class SourceFacade extends Facade<Source> {

    public List<Source> getAll() {
        return em.createNamedQuery("Source.getAll", Source.class).getResultList();
    }

    public Source getById(Long id) {
        EntityGraph eg = em.getEntityGraph("source-entity-graph");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", eg);
        return em.find(Source.class, id, properties);
    }

}
