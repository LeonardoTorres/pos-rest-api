/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.fjn.pos.api;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author leonardo
 */
@ApplicationPath("api")
public class PosApplication extends ResourceConfig {

    public PosApplication() {
        packages("br.fjn.pos.api.resources", "br.fjn.pos.api.filters");
    }
    
    
}
