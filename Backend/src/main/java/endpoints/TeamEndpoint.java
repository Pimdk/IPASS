package endpoints;

import dbcontexts.TeamTestContext;
import repositories.TeamRepository;
import utils.ResponseBuilder;

import javax.annotation.security.PermitAll;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/team")
public class TeamEndpoint {
    private TeamRepository teamRepository = new TeamRepository(new TeamTestContext());

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
