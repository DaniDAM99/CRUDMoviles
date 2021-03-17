/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Moviles;
import modelo.MovilesCRUD;

/**
 * REST Web Service
 *
 * @author Cristian
 */
@Path("moviles")
public class MovilesAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MovilesAPI
     */
    public MovilesAPI() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Moviles> getMoviles() {
        return MovilesCRUD.getMoviles();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Moviles getMovil(@PathParam("id") int id) {
        Moviles prod = MovilesCRUD.getMovil(id);
        return prod;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Moviles insertProductos(Moviles movil) {
        MovilesCRUD.insertarMovil(movil);
        return movil;
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Moviles putJson(Moviles m) {
        MovilesCRUD.actualizarMovil(m);
        return m;
    }


    @DELETE
    @Path("/{id}")
    public void insertProductos(@PathParam("id") int id) {
        MovilesCRUD.borrarMovil(id);
    }
}
