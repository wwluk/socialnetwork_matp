package pl.edu.agh.matp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: mjamroz
 * Date: 6/21/13
 * Time: 5:32 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(){
        return "home";
    }

}
