package endpoints;

import dbcontexts.CompetitionTestContext;
import repositories.CompetitionRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
}
