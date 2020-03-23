package at.htl.coincollection.database;

import at.htl.coincollection.model.Coin;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityGraph;
import java.util.HashMap;
import java.util.List;

@ApplicationScoped
public class CoinFacade extends Facade<Coin> {

    @Inject
    SourceFacade sourceFacade;
    @Inject
    CurrencyFacade currencyFacade;
    @Inject
    CollectorFacade collectorFacade;

    public List<Coin> getAll() {
        return em.createNamedQuery("Coin.getAll", Coin.class).getResultList();
    }

    public Coin getById(Long id) {
        EntityGraph eg = em.getEntityGraph("coin-entity-graph");
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("javax.persistence.fetchgraph", eg);
        return em.find(Coin.class, id, properties);
    }

}
