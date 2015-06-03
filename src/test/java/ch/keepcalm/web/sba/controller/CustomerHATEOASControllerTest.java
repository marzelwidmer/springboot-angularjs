package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.Application;
import ch.keepcalm.web.sba.domain.Customer;
import ch.keepcalm.web.sba.repository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by marcelwidmer on 31/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
@WebIntegrationTest({"server.port=7778", "management.port=0"})
public class CustomerHATEOASControllerTest  {


    @Autowired
    private CustomerRepository repository;

    private static final String REST_SERVICE_URL = "http://127.0.0.1:7778/hal/customer/";



    @Test
    public void testCustomerAndAssertUser() {
        Customer customer = new Customer();
        customer.setFirstname("Marcel");
        customer.setLastname("Widmer");

        RestTemplate restTemplate = new RestTemplate();
        Customer createdUser = restTemplate.postForObject(REST_SERVICE_URL, customer, Customer.class);
        assertNotNull(createdUser);
        assertEquals("Widmer", createdUser.getLastname());

    }


}