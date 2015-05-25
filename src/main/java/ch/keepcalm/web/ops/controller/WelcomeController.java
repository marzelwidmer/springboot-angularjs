package ch.keepcalm.web.ops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@RestController
public class WelcomeController {


    @RequestMapping("/")
    public ModelAndView welcome() {
        //return "Welcome";
        return new ModelAndView("welcome");

    }

    @RequestMapping("/ready")
    public String ready() {
        return "Ready";
    }


}
