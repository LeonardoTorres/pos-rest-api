/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.resources;

import br.fjn.pos.api.domain.customers.Customer;
import br.fjn.pos.api.domain.customers.CustomersService;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author leonardo
 */
@Path("customers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomersResource {
    
    @Inject
    private CustomersService customersService;
    
    @POST
    public Response create(Customer customer){
        try {
            this.customersService.create(customer);
            return Response.status(Response.Status.CREATED).build();
        } catch (Exception ex) {
            return null;
        }
        
    }
    
    @PUT
    public Response update(Customer customer){
       this.customersService.update(customer);
       return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") String id){
       this.customersService.delete(id);
       return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    // Path Param - /customer/id --> retorna uma cliente de acordo com um id passado
    @GET
    @Path("{id}")
    public Response getById(@PathParam("id") String id){
        Customer customer = this.customersService.findById(id);
        if (customer == null){
             return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(customer).build();
    }
    
    // Path Param - /customes --> retorna todos os clientes
    @GET
    public Response getCustomers(){
        return Response.ok().entity(this.customersService.list()).build();
    }
    
}
