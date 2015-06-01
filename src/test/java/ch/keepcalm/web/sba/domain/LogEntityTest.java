package ch.keepcalm.web.sba.domain;

import ch.keepcalm.web.sba.Application;
import ch.keepcalm.web.sba.repository.LogRepository;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.UnsupportedEncodingException;


/**
 * Created by marcelwidmer on 01/06/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class LogEntityTest extends TestCase {


    @Autowired
    private LogRepository repository;


    @Test
    public void testWriteSomeLog() {
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

        repository.saveAndFlush(logEntity);
    }


}