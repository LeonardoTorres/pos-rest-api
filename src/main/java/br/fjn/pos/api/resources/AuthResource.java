/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.resources;

import br.fjn.pos.api.domain.auth.Credentials;
import br.fjn.pos.api.exceptions.APIException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author leonardo
 */



@Path("auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AuthResource {
    
    
    @POST
    public Response authenticate(Credentials credentials){
         if (!credentials.getUsername().equalsIgnoreCase("joao") && !credentials.getPassword().equals("123")){
            throw new APIException(Response.Status.FORBIDDEN.getStatusCode(), "forbidden");
         }
         return Response.ok().build();
        
    }
}
