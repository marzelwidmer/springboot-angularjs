package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

/**
 * Created by marcelwidmer on 24/05/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
@WebIntegrationTest({"server.port=7777", "management.port=0", "shell.telnet.port=0", "shell.ssh.port=0"})
public class ReadyControllerTest {


    @Test
    public void testReady() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        assertEquals("UP", restTemplate.getForObject(
                "http://127.0.0.1:7777/ready/", String.class));
    }


}