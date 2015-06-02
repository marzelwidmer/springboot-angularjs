package ch.keepcalm.web.sba.controller;

import ch.keepcalm.web.sba.Application;
import ch.keepcalm.web.sba.domain.LogEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertNotNull;

/**
 * Created by marcelwidmer on 01/06/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebIntegrationTest({"server.port=7779", "management.port=0"})
public class LogRestControllerTest {

    private static final String REST_SERVICE_URL = "http://127.0.0.1:7779/api/log/";

    @Test
    public void testLogRestController() {
        LogEntity logEntity = new LogEntity();
        logEntity.setSpaClientApplikation("myApplication");
        logEntity.setSpaClientVersion("my cleint version");
        logEntity.setSpaCorrelationId("my colorrelatinID");
        logEntity.setSpaFaultCode("myFaultCoder");
        logEntity.setSpaFaultType("myFaultType");
        logEntity.setSpaSeverity("mySeverity");

        // TODO logEntity.setSpaTimestamp(); (wird serverseitig erstell)
        try {
            logEntity.setSpaDebugInformation("Das ist eine Debug Message".getBytes("UTF-8"));
            logEntity.setSpaMeldung("Meine Message".getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        RestTemplate restTemplate = new RestTemplate();
        String log = restTemplate.postForObject(REST_SERVICE_URL, logEntity, String.class);
        assertNotNull(log);


        ResponseEntity<LogEntity> logEntityResponseEntity = new ResponseEntity<LogEntity>(logEntity, HttpStatus.CREATED);

        System.out.println(logEntityResponseEntity);


    }

}