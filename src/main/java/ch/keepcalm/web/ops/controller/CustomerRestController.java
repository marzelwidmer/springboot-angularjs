package ch.keepcalm.web.ops.controller;

import ch.keepcalm.web.ops.domain.Customer;
import ch.keepcalm.web.ops.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping("/customer/add/{name}")
    public void addCustomer(@PathVariable String name) {
        this.customerService.add(name);
    }


    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        Customer customer = new Customer();
        customer.setId(id);
        customerService.delete(customer);

    }

}
