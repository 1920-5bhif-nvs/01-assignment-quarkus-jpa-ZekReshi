package at.htl.coincollection.database;

import at.htl.coincollection.model.Coin;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
        return em.find(Coin.class, id);
    }

}
