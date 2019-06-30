package endpoints;

import dbcontexts.TeamTestContext;
import models.Team;
import repositories.TeamRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

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

    @GET
    @Produces("application/json")
    public Response getAllTeams() {
        ArrayList<Team> teams = new ArrayList<>(teamRepository.getAllTeams());
        try {
            return ResponseBuilder.response(serializer.serialize(teams));
        }
        catch (Exception e)
        {
            return ResponseBuilder.response("Something went wrong", 500);
        }
    }
}
