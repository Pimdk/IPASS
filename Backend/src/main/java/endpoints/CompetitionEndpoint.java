package endpoints;

import dbcontexts.CompetitionTestContext;
import models.Competition;
import repositories.CompetitionRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/competitions")
public class CompetitionEndpoint {
    private CompetitionRepository competitionRepository = new CompetitionRepository(new CompetitionTestContext());
    private Serializer<String> serializer = SerializerSingleton.getInstance();

    @GET
    @Path("/test")
    public Response testConnection()
    {
        return ResponseBuilder.response("Competition Endpoint Connection Successful");
    }

    @GET
    @Produces("application/json")
    public Response getAllCompetitions() {
        ArrayList<Competition> competitions = new ArrayList<>(competitionRepository.getAllCompetitions());
        try {
            return ResponseBuilder.response(serializer.serialize(competitions));
        }
        catch (Exception e)
        {
            return ResponseBuilder.response("Something went wrong", 500);
        }
    }
}
