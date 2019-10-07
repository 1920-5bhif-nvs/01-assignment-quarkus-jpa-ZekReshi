package at.htl.coincollection.rest;

import at.htl.coincollection.database.CurrencyFacade;
import at.htl.coincollection.model.Currency;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("currencies")
public class CurrencyEndpoint {

    @Inject
    CurrencyFacade currencyFacade;

    @GET
    public Response getAll() {
        List<Currency> currencies = currencyFacade.getAll();
        return Response.ok().entity(currencies).build();
    }

}
