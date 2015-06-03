package ch.keepcalm.web.sba.repository;

import ch.keepcalm.web.sba.domain.LoggingStore;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marcelwidmer on 03/06/15.
 */
public interface LoggingStoreRepository extends JpaRepository<LoggingStore, Long> {

}
