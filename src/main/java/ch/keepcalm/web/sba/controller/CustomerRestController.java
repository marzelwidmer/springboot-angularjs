package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public List<Customer> customer() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer customer(@PathVariable Long id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }


    @RequestMapping("/customer/add/{name}")
    public void addCustomer(@PathVariable String name) {
        this.customerService.add(name);
    }
    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity<Customer> add(@RequestBody Customer customer) {
        // TODO evtl. call over service layert ?
        this.customerService.add(customer);
        return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
    }




    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String id) {
        Customer customer = new Customer();
        customer.setId(id);
        customerService.delete(customer);
    }
}
