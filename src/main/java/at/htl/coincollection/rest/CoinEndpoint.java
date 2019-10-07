package at.htl.coincollection.rest;

import at.htl.coincollection.database.CoinFacade;
import at.htl.coincollection.model.Coin;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("coins")
public class CoinEndpoint {

    @Inject
    CoinFacade coinFacade;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Coin> coins = coinFacade.getAll();
        return Response
                .ok()
                .entity(coins)
                .build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") long id) {
        Coin coin = coinFacade.getById(id);
        if (coin == null) {
            return Response
                    .status(404)
                    .build();
        }
        return Response
                .ok()
                .entity(coin)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(Coin coin) {
        coinFacade.insert(coin);
        return Response
                .noContent()
                .build();
    }

}
