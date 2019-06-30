package endpoints;

import dbcontexts.PlayerTestContext;
import models.Player;
import repositories.PlayerRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.annotation.security.PermitAll;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/player")
public class PlayerEndpoint {
    private PlayerRepository playerRepository = new PlayerRepository(new PlayerTestContext());
    private Serializer<String> serializer = SerializerSingleton.getInstance();

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

    @GET
    @Path("/get")
    @Produces("application/json")
    public Response getAllPlayers() {
        ArrayList<Player> players = new ArrayList<>(playerRepository.getAllPlayers());
        try {
            return ResponseBuilder.response(serializer.serialize(players));
        }
        catch (Exception e)
        {
            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @GET
    @Path("/get/{id}")
    @Produces("application/json")
    public Response getPlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        Player player = playerRepository.getPlayer(id);
        try {
            return ResponseBuilder.response(serializer.serialize(player));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }
}
