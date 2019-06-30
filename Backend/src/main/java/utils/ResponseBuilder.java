package utils;

import javax.ws.rs.core.Response;

public final class ResponseBuilder {

    public static Response response(String result) {
        return Response.ok().entity(result).build();
    }

    public static Response response(String result, int status) {
        return Response.status(status).entity(result).build();
    }
}
