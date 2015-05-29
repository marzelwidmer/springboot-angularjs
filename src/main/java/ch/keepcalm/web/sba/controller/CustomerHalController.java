package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * Created by marcelwidmer on 25/05/15.
 */
@RestController
@RequestMapping("/hal/customer/")
public class CustomerHalController {

    @Autowired
    private CustomerService customerService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer customer(@PathVariable Long id) {
        Customer customer = customerService.findOne(id);
        return customer;
    }


    @RequestMapping("/")
    public List<ShortContact> customer() {
        List<Customer> customers = customerService.findAll();
        List<ShortContact> resources = new ArrayList<ShortContact>(customers.size());
        for(Customer customer : customers) {
            ShortContact resource = new ShortContact();
            resource.setFirstname(customer.getFirstname());
            resource.setLastname(customer.getLastname());
            Link detail = linkTo(CustomerHalController.class).slash(customer.getId()).withSelfRel();
            resource.add(detail);
            resources.add(resource);
        }
        return resources;
    }


    @RequestMapping("add/{name}")
    public void addCustomer(@PathVariable String name) {
        this.customerService.add(name);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
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
