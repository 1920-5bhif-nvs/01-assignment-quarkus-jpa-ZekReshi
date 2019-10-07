package at.htl.coincollection.database;

import at.htl.coincollection.model.Currency;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CurrencyFacade extends Facade<Currency>{

    public List<Currency> getAll() {
        return em.createNamedQuery("Currency.getAll", Currency.class).getResultList();
    }

    public Currency getById(Long id) {
        return em.find(Currency.class, id);
    }

}
