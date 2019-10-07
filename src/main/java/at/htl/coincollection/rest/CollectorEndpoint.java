package at.htl.coincollection.rest;

import at.htl.coincollection.database.CollectorFacade;
import at.htl.coincollection.model.Collector;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("collectors")
public class CollectorEndpoint {

    @Inject
    CollectorFacade collectorFacade;

    @GET
    public Response getAll() {
        List<Collector> collectors = collectorFacade.getAll();
        return Response.ok().entity(collectors).build();
    }

}
