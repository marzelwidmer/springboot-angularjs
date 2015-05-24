package ch.keepcalm.web.ops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@RestController
public class HelloController {


    @RequestMapping("/")
    public String hello() {
        return "Hello";
    }
}
