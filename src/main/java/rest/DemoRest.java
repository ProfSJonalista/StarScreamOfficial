package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/demo")
public class DemoRest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response test(){
		return Response.ok("working").build();
	}
}
