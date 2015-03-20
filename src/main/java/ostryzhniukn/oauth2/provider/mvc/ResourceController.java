package ostryzhniukn.oauth2.provider.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by nazar on 3/19/15.
 */
@Controller
public class ResourceController {

    @RequestMapping("/resource")
    @ResponseBody
    public String resource(){
        return "Oauth2 provider mvc resource!";
    }
}
