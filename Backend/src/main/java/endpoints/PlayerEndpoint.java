package endpoints;

import utils.ResponseBuilder;
import utils.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;

@Path("/player")
public class PlayerEndpoint {

    @GET
    @Path("/get")
    @Produces("application/json")
    public Response getAllPlayers(){
        ArrayList<Episode> episodes = new ArrayList<>(repository.getAll(Episode.class, -1));
        try {
            return ResponseBuilder.response(Serializer.getInstance().writeValueAsString(episodes));
        } catch (JsonProcessingException e) {
            Logger.getInstance().log(e);
            return ResponseBuilder.response("Something went wrong", 500);
        }
    }

    @POST
    @Path("/create")
    @Produces("application/json")
    public Response createPlayer(String jsonPlayer) {
        Episode episode;
        try {
            episode = Serializer.getInstance().readValue(jsonEpisode, Episode.class);
            repository.add(episode);
        } catch (IOException e) {
            Logger.getInstance().log(e);
            return ResponseBuilder.response("Could not read JSON", 500);
        }

        try {
            return ResponseBuilder.response(Serializer.getInstance().writeValueAsString(episode));
        } catch (JsonProcessingException e) {
            Logger.getInstance().log(e);
            return ResponseBuilder.response("Could not write JSON", 500);
        }
    }
}
