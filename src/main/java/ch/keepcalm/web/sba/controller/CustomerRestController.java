package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ResourceSupport;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Customer customer(@PathVariable Long id) {
        Customer customer = customerService.findOne(id);
        return customer;
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



    public static class ShortContact extends ResourceSupport {

        private String firstname;
        private String lastname;

        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }


        public String getFirstname() {
            return firstname;
        }

        public void setFirstname(String firstname) {
            this.firstname = firstname;
        }
    }

}
