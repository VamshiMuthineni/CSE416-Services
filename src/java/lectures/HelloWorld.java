/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectures;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vamshimuthineni
 */
@Path("helloworld")
public class HelloWorld {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    /**
     * Retrieves representation of an instance of lectures.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        return "<html><body><h1>Hello, World!</h1></body></html>";
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    @GET
    @Path("/{username}")
    @Produces("text/html")
    public String getUser(@PathParam("username") String userName) {
        return "<html><body><h1>Hello " + userName + "!!</body></h1></html>";
    }
    
    @GET
    @Path("/query")
    @Produces("text/html")
    public String getUserWithQuery(@QueryParam("query") String userName) {
        return "<html><body><h1>Your Query: " + userName + "!!</body></h1></html>";
    }
    
    
    @GET
    @Path("/{cnum}/query")
    @Produces(MediaType.TEXT_PLAIN)
    public String getCard(@PathParam("cnum") int cardNumber) {
        String s1 = "<html><body><h1>";
        String s2 = "</h1></body></html>";
        if (cardNumber == 123) {
            String message = "{num:123, nickname:'Alonzo' type:'Adult'}";
            return s1 + message + s2;
        } else {
            return s1 + "Would you like to apply for a library card?" + s2;
        }
    }
}
