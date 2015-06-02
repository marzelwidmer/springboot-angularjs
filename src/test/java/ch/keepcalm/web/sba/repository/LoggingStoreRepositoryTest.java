package ch.keepcalm.web.sba.repository;

import ch.keepcalm.web.sba.Application;
import ch.keepcalm.web.sba.domain.LoggingStore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@Transactional
@TransactionConfiguration(defaultRollback = true)
@ActiveProfiles(profiles = "development")
public class LoggingStoreRepositoryTest {

    @Autowired
    private LoggingStoreRepository repository;

    @Test
    public void testCreatAndFind() {

        LoggingStore loggingStore = new LoggingStore();
        loggingStore.setDescription("myDescription");
        loggingStore.setTitle("myTitle");
        loggingStore.setVersion(1234241);
        repository.saveAndFlush(loggingStore);

        assertEquals("myTitle", repository.findOne(1l).getTitle());

    }
}
