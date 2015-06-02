package ch.keepcalm.web.sba.repository;

import ch.keepcalm.web.sba.domain.LoggingStore;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by marcelwidmer on 02/06/15.
 */
public interface LoggingStoreRepository extends JpaRepository<LoggingStore, Long> {
/*    @Query(
            "Select t FROM LoggingStore t WHERE LOWER(t.title) LIKE LOWER(CONCAT('%', :searchTerm, '%')) " +
                    "OR LOWER(t.description) LIKE LOWER(CONCAT('%', :searchTerm, '%'))"
    )
    public List<Todo> search(@Param("searchTerm") String searchTerm);*/
}