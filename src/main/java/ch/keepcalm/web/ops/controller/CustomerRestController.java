package ch.keepcalm.web.ops.controller;

import ch.keepcalm.web.ops.domain.Customer;
import ch.keepcalm.web.ops.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by marcelwidmer on 25/05/15.
 */
@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customer")
    public List<Customer> customer() {
        return customerService.findAll();
    }
}
