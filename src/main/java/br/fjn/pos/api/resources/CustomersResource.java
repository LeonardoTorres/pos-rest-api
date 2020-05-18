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
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author leonardo
 * http status code 200: OK
 * http status code 201: Created
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
    
}
