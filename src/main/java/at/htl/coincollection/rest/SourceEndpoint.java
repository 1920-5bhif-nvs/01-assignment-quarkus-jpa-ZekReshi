package at.htl.coincollection.rest;

import at.htl.coincollection.database.SourceFacade;
import at.htl.coincollection.model.Source;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("sources")
public class SourceEndpoint {

    @Inject
    SourceFacade sourceFacade;

    @GET
    public Response getAll() {
        List<Source> sources = sourceFacade.getAll();
        return Response.ok().entity(sources).build();
    }

}