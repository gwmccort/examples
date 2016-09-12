package gwm.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 * Simple hello world jax-rs jersy webservice example.
 * 
 * @author Glen
 * @see <a href=
 *      "http://www.mkyong.com/webservices/jax-rs/jersey-hello-world-example/">
 *      jersey hello world example</a>
 */
@Path("/hello")
public class HelloWorldService {

	/**
	 * Handles one required parameter when is a message to echo back.
	 * 
	 * @param msg
	 * @return
	 */
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;

		return Response.status(200).entity(output).build();

	}

	/**
	 * Handles two required parameters
	 * 
	 * @param name
	 * @param message
	 * @return
	 */
	@GET
	@Path("/{name}/{message}")
	public Response getNameMessage(@PathParam("name") String name, @PathParam("message") String message) {
		return Response.ok().entity("test").build();
	}

}