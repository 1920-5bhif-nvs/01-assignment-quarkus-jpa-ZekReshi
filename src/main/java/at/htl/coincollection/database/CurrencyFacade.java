package at.htl.coincollection.database;

import at.htl.coincollection.model.Coin;
import at.htl.coincollection.model.Currency;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class CurrencyFacade extends Facade<Currency>{

    public List<Currency> getAll() {
        return em.createNamedQuery("Currency.getAll", Currency.class).getResultList();
    }

    public Currency getById(Long id) {
        EntityGraph eg = em.getEntityGraph("currency-entity-graph");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", eg);
        return em.find(Currency.class, id, properties);
    }

}
