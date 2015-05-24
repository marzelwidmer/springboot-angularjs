package ch.keepcalm.web.ops.controller;

import ch.keepcalm.web.ops.OpsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = OpsApplication.class)
@IntegrationTest
@WebAppConfiguration
public class HelloControllerTest  {


    @Test
    public void testHello() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("Hello", restTemplate.getForObject(
                "http://127.0.0.1:8080", String.class));

    }
}