package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.repository.CustomerRepository;
import ch.keepcalm.web.sba.service.CustomerService;
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

    // Test daten
    @Autowired
    CustomerRepository repository;


    @RequestMapping("/customer")
    public ModelAndView customer() {
        List<Customer> all = customerService.findAll();

        for (Customer customer : all) {
            System.out.println("Customer firstName: " + customer.getLastname());
        }
        //lambda
        //JAVA 8: FROM A FOR-LOOP TO FOREACH STATEMENT
       /* all.stream().forEach((customer) -> {
            System.out.println("Content: " + customer.getFirstName());
       });*/
        return new ModelAndView("customer/customerlist", "customers", customerService.findAll());
    }


    @RequestMapping("/loadData")
    public ModelAndView loadData() throws Exception {
        insertTestData();
        return new ModelAndView("customer/customerlist", "customers", customerService.findAll());

    }

    @RequestMapping("/clearData")
    public ModelAndView clearData() throws Exception {
        repository.deleteAll();
        return new ModelAndView("customer/customerlist", "customers", customerService.findAll());
    }

    @RequestMapping("/loadDataAngular")
    public String loadDataAngularRedirect() throws Exception {
        insertTestData();
        return "redirect:app/index.html";
    }

    @RequestMapping("/clearDataAngular")
    public String clearDataAngularRedirect() throws Exception {
        repository.deleteAll();
        return "redirect:app/index.html";
    }


    private void insertTestData() {
        // save a couple of customers
        repository.save(new Customer("Jack", "Bauer"));
        repository.save(new Customer("Chloe", "O'Brian"));
        repository.save(new Customer("Kim", "Bauer"));
        repository.save(new Customer("David", "Palmer"));
        repository.save(new Customer("Michelle", "Dessler"));


        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer by ID
        Customer customer = repository.findOne(1L);
        System.out.println("Customer found with findOne(1L):");
        System.out.println("--------------------------------");
        System.out.println(customer);
        System.out.println();

        // fetch customers by last name
        System.out.println("Customer found with findByLastName('Bauer'):");
        System.out.println("--------------------------------------------");
        for (Customer bauer : repository.findByLastname("Bauer")) {
            System.out.println(bauer);
        }
    }


}
