/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.filters;

import br.fjn.pos.api.annotations.Auth;
import br.fjn.pos.api.exceptions.APIException;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author leonardo
 */
@Auth
@Provider
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
      String authorizationHeader = requestContext.getHeaderString("Authorization");
      // JWT Token ? 
      if (authorizationHeader == null || authorizationHeader.isEmpty()){
          throw new APIException(Response.Status.UNAUTHORIZED.getStatusCode(), "unauthorized");
      }
    }
    
}
