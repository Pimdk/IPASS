package endpoints;

import dbcontexts.TeamTestContext;
import repositories.TeamRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/teams")
public class TeamEndpoint {
    private TeamRepository teamRepository = new TeamRepository(new TeamTestContext());
    private Serializer<String> serializer = SerializerSingleton.getInstance();

    @GET
    @Path("/test")
    public Response testConnection()
    {
        return ResponseBuilder.response("Team Endpoint Connection Successful");
    }
}
