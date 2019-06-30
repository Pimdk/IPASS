package endpoints;

import dbcontexts.CompetitionTestContext;
import repositories.CompetitionRepository;
import utils.ResponseBuilder;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/competition")
public class CompetitionEndpoint {
    private CompetitionRepository competitionRepository = new CompetitionRepository(new CompetitionTestContext());

    @OPTIONS
    @PermitAll
    public Response options(){
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @GET
    @Path("/test")
    public Response testConnection()
    {
        return ResponseBuilder.response("Test");
    }
}
