package com.netcracker;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class CalculationController {

    @GET
    @Path("/add/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String add(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a + b;
        return "<html>" +
                "<title>" + "Hello from Jersey" + "</title>" +
                "<body><h1>" + a + "+" + b + "=" + result + "</h1></body>" +
                "</html>";
    }

    @POST
    @Path("/add/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPost(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a + b;
        return Response.status(200).entity(result).build();
    }


    @GET
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String sub(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a - b;
        return "<html>" +
                "<title>" + "Hello from Jersey" + "</title>" +
                "<body><h1>" + a + "-" + b + "=" + result + "</h1></body>" +
                "</html>";
    }

    @POST
    @Path("/sub/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response subPost(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a - b;
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String mul(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a * b;
        return "<html>" +
                "<title>" + "Hello from Jersey" + "</title>" +
                "<body><h1>" + a + "*" + b + "=" + result + "</h1></body>" +
                "</html>";
    }

    @POST
    @Path("/mul/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response mulPost(@PathParam("a") int a, @PathParam("b") int b) {
        int result = a * b;
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("/div/{a}/{b}")
    @Produces(MediaType.TEXT_HTML)
    public String changeMessage(@PathParam("a") int a, @PathParam("b") int b) {
        if (b == 0) return "<html>" +
                "<title>" + "Hello from Jersey" + "</title>" +
                "<body><h1>" + "Can't divide by 0" + "</h1></body>" +
                "</html>";

        double result = a / b;

        return "<html>" +
                "<title>" + "Hello from Jersey" + "</title>" +
                "<body><h1>" + a + "/" + b + "=" + result + "</h1></body>" +
                "</html>";
    }

    @POST
    @Path("/div/{a}/{b}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response divPost(@PathParam("a") double a, @PathParam("b") double b) {
        if (b == 0) return Response.status(400).entity("Can't divide by 0").build();
        double result = a / b;
        return Response.status(200).entity(result).build();
    }
}
