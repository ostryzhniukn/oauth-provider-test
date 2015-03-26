/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package ostryzhniukn.oauth2.provider.mvc;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import ostryzhniukn.oauth2.provider.domain.Address;
import ostryzhniukn.oauth2.provider.domain.UserRole;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Jersey2 Spring integration example.
 * Demonstrate how to inject a Spring bean into a Jersey managed JAX-RS resource class.
 *
 * @author Marko Asplund (marko.asplund at gmail.com)
 */
@Path("/")
public class JerseyResource {
    private static final Logger LOGGER = Logger.getLogger(JerseyResource.class.getName());

    public JerseyResource() {
        LOGGER.fine("HelloWorldResource()");
    }

    @GET
    @Path("jersey-hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String getHello() {
        return "Provider Jersey resource";
    }

    private static Log logger = LogFactory.getLog(JerseyResource.class);

    @GET
    @Path("check")
    @Produces(MediaType.TEXT_PLAIN)
    public String check() {
        return "Checked!";
    }

    @POST
    @Path("check2")
    @Produces(MediaType.TEXT_PLAIN)
    public String check(String message) {
        return message;
    }

    @POST
    @Path("createAddress1")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createAddress1(Address address){
        //addressService.insertAddress(address);
        return Response.status(Response.Status.CREATED).build();
    }
    @POST
    @Path("createAddress")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createAddress(Address address){
        //addressService.insertAddress(address);
        address.setCity("I-F");
        return Response.status(Response.Status.CREATED).entity(address).build();
    }

    @POST
    @Path("userRole")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response userRole(UserRole userRole){
        //addressService.insertAddress(address);
        userRole.setUser("User with role");
        return Response.status(Response.Status.CREATED).entity(userRole).build();
    }

}
