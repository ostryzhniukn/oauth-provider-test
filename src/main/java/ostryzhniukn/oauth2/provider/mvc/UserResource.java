package ostryzhniukn.oauth2.provider.mvc;

import ostryzhniukn.oauth2.provider.entity.UserBean;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by nazar on 3/25/15.
 */
@Path("userDetails")
@Produces(MediaType.APPLICATION_JSON)

public class UserResource{

    @GET
    public Response userDetails(){
        UserBean userRole = new UserBean(1, "user with noName", "USER");
        return Response.status(Response.Status.OK).entity(userRole).build();
    }
}
