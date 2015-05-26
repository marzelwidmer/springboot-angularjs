package ch.keepcalm.web.ops.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by marcelwidmer on 26/05/15.
 */
@Controller
public class WelcomeController {


    @RequestMapping("/")
    public ModelAndView welcome() {
        //return "Welcome";
        return new ModelAndView("welcome");

    }

}
