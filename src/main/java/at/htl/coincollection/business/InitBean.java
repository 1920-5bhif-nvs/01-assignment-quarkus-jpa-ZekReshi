package at.htl.coincollection.business;

import at.htl.coincollection.database.CoinFacade;
import at.htl.coincollection.database.CollectorFacade;
import at.htl.coincollection.database.CurrencyFacade;
import at.htl.coincollection.database.SourceFacade;
import at.htl.coincollection.model.Coin;
import at.htl.coincollection.model.Collector;
import at.htl.coincollection.model.Currency;
import at.htl.coincollection.model.Source;
import io.quarkus.runtime.StartupEvent;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class InitBean {

    @Inject
    CoinFacade coinFacade;
    @Inject
    CollectorFacade collectorFacade;
    @Inject
    CurrencyFacade currencyFacade;
    @Inject
    SourceFacade sourceFacade;

    @Transactional
    public void init(@Observes StartupEvent ev) {
        Collector florian = new Collector("Florian", "Schwarcz");
        collectorFacade.insert(florian);
        Currency groschen = new Currency("Groschen");
        currencyFacade.insert(groschen);
        Source kaffeedose = new Source("Kaffeedose");
        sourceFacade.insert(kaffeedose);

        Coin coin1 = new Coin(10, 10, 1990, kaffeedose, groschen, florian);
        Coin coin2 = new Coin(50, 5, 1991, kaffeedose, groschen, florian);
        coinFacade.insert(coin1);
        coinFacade.insert(coin2);
    }

}
