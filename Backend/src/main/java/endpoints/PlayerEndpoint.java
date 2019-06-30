package endpoints;

import dbcontexts.PlayerTestContext;
import models.Player;
import repositories.PlayerRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/players")
public class PlayerEndpoint {
    private PlayerRepository playerRepository = new PlayerRepository(new PlayerTestContext());
    private Serializer<String> serializer = SerializerSingleton.getInstance();

    @GET
    @Path("test")
    public Response testConnection()
    {
        return ResponseBuilder.response("Player Endpoint Connection Successful");
    }

    @GET
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
    @Path("/{id}")
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

    @POST
    @Path("/{id}")
    @Produces("application/json")
    public Response createPlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        Player player = playerRepository.getPlayer(id);
        try {
            return ResponseBuilder.response(serializer.serialize(player));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @PUT
    @Path("/{id}")
    @Produces("application/json")
    public Response updatePlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        Player player = playerRepository.getPlayer(id);
        try {
            return ResponseBuilder.response(serializer.serialize(player));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deletePlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        Player player = playerRepository.getPlayer(id);
        try {
            return ResponseBuilder.response(serializer.serialize(player));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }
}
