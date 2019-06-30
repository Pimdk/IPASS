package endpoints;

import dbcontexts.PlayerTestContext;
import models.Player;
import repositories.PlayerRepository;
import utils.ResponseBuilder;
import utils.serialization.Serializer;
import utils.serialization.SerializerSingleton;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/players")
public class PlayerEndpoint {
    private PlayerRepository playerRepository = new PlayerRepository(new PlayerTestContext());
    private Serializer<String> serializer = SerializerSingleton.getInstance();

    @GET
    @Path("test")
    public Response testConnection() {
        return ResponseBuilder.response("Player Endpoint Connection Successful");
    }

    @GET
    @Produces("application/json")
    public Response getAllPlayers() {
        try {
            return ResponseBuilder.response(serializer.serialize(playerRepository.getAllPlayers()));
        } catch (Exception e) {
            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getPlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        try {
            return ResponseBuilder.response(serializer.serialize(playerRepository.getPlayer(id)));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @POST
    @Path("/{player}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response createPlayer(@PathParam("player") String jsonPlayer) {
        Player player = serializer.deserialize(jsonPlayer, Player.class);
        try {
            playerRepository.addNewPlayer(player);
            return ResponseBuilder.response(serializer.serialize(playerRepository.getPlayer(player.getId())));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @PUT
    @Path("/{player}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/json")
    public Response updatePlayer(@PathParam("player") String jsonPlayer) {
        Player player = serializer.deserialize(jsonPlayer, Player.class);
        try {
            playerRepository.updatePlayer(player);
            return ResponseBuilder.response(serializer.serialize(playerRepository.getPlayer(player.getId())));
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response deletePlayer(@PathParam("id") String jsonID) {
        int id = Integer.parseInt(jsonID);
        try {
            playerRepository.deletePlayer(id);
            return ResponseBuilder.response("Player with id: " + id + " removed.", 200);
        } catch (Exception e) {

            return ResponseBuilder.response("Something went wrong", 500);
        }
    }
}
