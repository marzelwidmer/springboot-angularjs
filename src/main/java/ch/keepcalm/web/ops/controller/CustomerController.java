package ch.keepcalm.web.ops.controller;

import ch.keepcalm.web.ops.domain.Customer;
import ch.keepcalm.web.ops.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by marcelwidmer on 25/05/15.
 */
@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping("/customer")
    public ModelAndView customer() {
        List<Customer> all = customerService.findAll();

        for (Customer customer : all) {
            System.out.println("Customer firstName: " + customer.getName());
        }
        //lambda
        //JAVA 8: FROM A FOR-LOOP TO FOREACH STATEMENT
       /* all.stream().forEach((customer) -> {
            System.out.println("Content: " + customer.getFirstName());
       });*/
        return new ModelAndView("customer/customerlist", "customers", customerService.findAll());
    }
}
