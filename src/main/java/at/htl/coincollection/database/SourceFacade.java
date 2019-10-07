package at.htl.coincollection.database;

import at.htl.coincollection.model.Source;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class SourceFacade extends Facade<Source> {

    public List<Source> getAll() {
        return em.createNamedQuery("Source.getAll", Source.class).getResultList();
    }

    public Source getById(Long id) {
        return em.find(Source.class, id);
    }

}
