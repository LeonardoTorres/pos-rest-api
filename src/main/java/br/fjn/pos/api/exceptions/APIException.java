/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api.exceptions;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

/**
 *
 * @author leonardo
 */
public class APIException extends WebApplicationException {

    public APIException(Integer code, String message) {
        super(Response.status(code).entity(new ExceptionInfo(code, message)).build());
    }


}
