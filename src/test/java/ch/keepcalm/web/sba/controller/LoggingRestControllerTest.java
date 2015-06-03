package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.Application;
import ch.keepcalm.web.sba.domain.LoggingStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertNotNull;

/**
 * Created by marcelwidmer on 01/06/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
@WebIntegrationTest({"server.port=7779", "management.port=0", "shell.telnet.port=0", "shell.ssh.port=0"})
public class LoggingRestControllerTest {

    private static final String REST_SERVICE_URL = "http://127.0.0.1:7779/log/";

    @Test
    public void testLogRestController() {
        LoggingStore loggingStore = new LoggingStore();
        loggingStore.setClientApplikation("JunitApplicationID");
        loggingStore.setClientVersion("JUnitClientVersion");


        RestTemplate restTemplate = new RestTemplate();
        String log = restTemplate.postForObject(REST_SERVICE_URL, loggingStore, String.class);
        assertNotNull(log);


        ResponseEntity<LoggingStore> logEntityResponseEntity = new ResponseEntity<LoggingStore>(loggingStore, HttpStatus.CREATED);

        System.out.println(logEntityResponseEntity);


    }

}