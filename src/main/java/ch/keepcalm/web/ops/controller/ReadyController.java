package ch.keepcalm.web.ops.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@RestController
public class ReadyController {


    @RequestMapping("/ready")
    public String ready() {
        return "Ready";
    }
}
