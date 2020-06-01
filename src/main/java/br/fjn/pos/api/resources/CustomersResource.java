/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.resources;

import br.fjn.pos.api.annotations.Auth;
import br.fjn.pos.api.domain.customers.Customer;
import br.fjn.pos.api.domain.customers.CustomersService;
import br.fjn.pos.api.exceptions.APIException;
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
            throw new APIException(Response.Status.BAD_REQUEST.getStatusCode(), ex.getMessage());
        }
        
    }
    
    @PUT
    public Response update(Customer customer){
       try{
           this.customersService.update(customer);
       }catch(Exception ex){
            throw new APIException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ex.getMessage());
       }
       
       return Response.status(Response.Status.NO_CONTENT).build();
    }
    
    @DELETE
    @Auth
    @Path("{id}")
    public Response remove(@PathParam("id") String id){
       try{
            this.customersService.delete(id);
       }catch (Exception ex){
            throw new APIException(Response.Status.NOT_FOUND.getStatusCode(), ex.getMessage());
       }       
       return Response.status(Response.Status.NO_CONTENT).build();
    }
    
   
    @GET
    @Auth
    @Path("{id}")
    public Response getById(@PathParam("id") String id){
        try{
            Customer customer = this.customersService.findById(id);
            return Response.status(Response.Status.OK).entity(customer).build();
        }catch(Exception ex){
            throw new APIException(Response.Status.NOT_FOUND.getStatusCode(), ex.getMessage());
        }
       
    }
    
 
    @GET
    @Auth
    public Response getCustomers(){
        try{
            return Response.ok().entity(this.customersService.list()).build();
        }catch (Exception ex){
             throw new APIException(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), ex.getMessage());
        }
       
    }
    
}
